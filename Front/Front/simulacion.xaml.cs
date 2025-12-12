using System;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Net.Sockets;
using System.Reflection.PortableExecutable;
using System.Security.Claims;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Shapes;
using static System.Net.WebRequestMethods;

namespace Front
{
    /// <summary>
    /// Interaction logic for simulacion.xaml
    /// </summary>
    public partial class simulacion : Window
    {
        public int N { get; set; }
        public string tHormiga { get; set; }
        public string tDepredador { get; set; }
        public string tClima { get; set; }
        public string tPath { get; set; }
        private int N2;
        private readonly SemaphoreSlim socketLock = new SemaphoreSlim(1, 1);

        private TcpClient cliente;
        private StreamWriter writer;
        private StreamReader reader;

        public simulacion(string hormiga, string depredador, string clima, string Path)
        {
            InitializeComponent();
            tHormiga = hormiga;
            tDepredador = depredador;
            tClima = clima;
            tPath = Path;

            this.Loaded += Simulacion_Loaded;
        }

        private async void btnEstadisticas_Click(object sender, RoutedEventArgs e)
        {
            string solicitud = "INFO;0";
            string respuesta = await EnviarSolicitud(solicitud);
            Estadisticas ventan_stats = new Estadisticas(respuesta);
            ventan_stats.ShowDialog();
        }

        public async void CrearGrilla(int N)
        {
            grillaSimulacion.RowDefinitions.Clear();
            grillaSimulacion.ColumnDefinitions.Clear();

            for (int i = 0; i < N; i++)
            {
                grillaSimulacion.RowDefinitions.Add(new RowDefinition());
                grillaSimulacion.ColumnDefinitions.Add(new ColumnDefinition());
            }

            for (int r = 0; r < N; r++)
            {
                for (int c = 0; c < N; c++)
                {
                    // Crear borde
                    Border borde = new Border
                    {
                        BorderBrush = Brushes.Black,
                        BorderThickness = new Thickness(0.5),
                        Background = Brushes.Transparent
                    };

                    // Crear celda interna
                    Grid celda = new Grid
                    {
                        Background = Brushes.Transparent
                    };

                    int rr = r;
                    int cc = c;

                    borde.Child = celda;
                    celda.MouseLeftButtonDown += (s, e) =>
                    {
                        AbrirVentanaInfo(rr, cc);
                    };

                    // Posicionar borde en la grilla
                    Grid.SetRow(borde, r);
                    Grid.SetColumn(borde, c);
                    grillaSimulacion.Children.Add(borde);

                    // Obtener categoría del backend
                    string categoria = await ObtenerCategoria(r, c);

                    Image img = null;

                    switch (categoria)
                    {
                        case "rio":
                            img = new Image
                            {
                                Source = new BitmapImage(new Uri("pack://application:,,,/recursos/poza.png", UriKind.Absolute)),
                                Stretch = Stretch.Uniform
                            };
                            break;

                        case "roca":
                            img = new Image
                            {
                                Source = new BitmapImage(new Uri("pack://application:,,,/recursos/stone.png", UriKind.Absolute)),
                                Stretch = Stretch.Uniform
                            };
                            break;
                    }

                    // Solo agregar imagen si no es null
                    if (img != null)
                        celda.Children.Add(img);
                }
            }
        }


        public async Task<string> ObtenerCategoria(int fila, int columna)
        {
            string solicitud = "TERRENO;"+fila+";"+ columna;
            string respuesta = await EnviarSolicitud(solicitud);
            return respuesta;
        }


        private void btnInformacion_Click(object sender, RoutedEventArgs e)
        {
            Informacion ventana_info = new Informacion(tHormiga, tClima, tDepredador);
            ventana_info.ShowDialog();
        }

        private async void SiguenteDia_Click(object sender, RoutedEventArgs e)
        {
            string solicitud = "NUEVODIA;";
            string respuesta = await EnviarSolicitud(solicitud);
            int dia = int.Parse(txtDiaActual.Text);
            dia += 1;
            txtDiaActual.Text = dia.ToString();
        }

        private async void Simulacion_Loaded(object sender, RoutedEventArgs e)
        {
            cliente = new TcpClient();
            await cliente.ConnectAsync("127.0.0.1", 5000);

            NetworkStream stream = cliente.GetStream();
            writer = new StreamWriter(stream) { AutoFlush = true };
            reader = new StreamReader(stream);
            await MandarConfig();
            N2 = await PedirTamano();

            CrearGrilla(N2);
        }

        public async Task<string> EnviarSolicitud(string mensaje)
        {
            await socketLock.WaitAsync();   

            try
            {
                await writer.WriteLineAsync(mensaje);
                string respuesta = await reader.ReadLineAsync();
                return respuesta;
            }
            finally
            {
                socketLock.Release(); 
            }
        }

        public async Task<int> PedirTamano()
        {
            string solicitud = "TAMANO";
            string respuesta = await EnviarSolicitud(solicitud);
            return int.Parse(respuesta);
        }

        public async Task MandarConfig()
        {
            string solicitud = "CONFIG;"+ tHormiga+";"+ tDepredador + ";" + tClima+ ";" + tPath;
            string respuesta = await EnviarSolicitud(solicitud);
        }

        public async void AbrirVentanaInfo(int fila, int columna)
        {
            string mensaje = await PedirNHormigaDepredador(fila, columna);
            string[] partes = mensaje.Split(';');
            int n_depredadores = int.Parse(partes[0]);
            int n_hormigas = int.Parse(partes[1]);
            VentanaInfo ventana = new VentanaInfo(n_hormigas, n_depredadores);
            ventana.ShowDialog();
        }

        public async Task<string> PedirNHormigaDepredador(int fila, int columna)
        {
            string solicitud = "NHORMIDEPREDA;" + fila+";"+columna;
            string respuesta = await EnviarSolicitud(solicitud);
            return respuesta;
        }

    }
}
