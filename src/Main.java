void main(String[] args) {

    if (args.length > 0 && args[0].equalsIgnoreCase("cli")) {
        new SistemaCLI().menu();
    } else {
        SistemaGUI.iniciar();
    }
}
