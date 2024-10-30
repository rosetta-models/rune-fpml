package fpml.confirmation;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import fpml.confirmation.BuyerSellerModel;
import fpml.confirmation.CalculationAgent;
import fpml.confirmation.CashSettlement;
import fpml.confirmation.Exercise;
import fpml.confirmation.ExerciseProcedure;
import fpml.confirmation.Payment;
import fpml.confirmation.Product;
import fpml.confirmation.Product.ProductBuilder;
import fpml.confirmation.Product.ProductBuilderImpl;
import fpml.confirmation.Product.ProductImpl;
import fpml.confirmation.ProductModel;
import fpml.confirmation.Swap;
import fpml.confirmation.Swaption;
import fpml.confirmation.Swaption.SwaptionBuilder;
import fpml.confirmation.Swaption.SwaptionBuilderImpl;
import fpml.confirmation.Swaption.SwaptionImpl;
import fpml.confirmation.SwaptionAdjustedDates;
import fpml.confirmation.SwaptionPhysicalSettlement;
import fpml.confirmation.meta.SwaptionMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A swaption product definition. A type to define an option on a swap.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="Swaption", builder=Swaption.SwaptionBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface Swaption extends Product {

	SwaptionMeta metaData = new SwaptionMeta();

	/*********************** Getter Methods  ***********************/
	BuyerSellerModel getBuyerSellerModel();
	/**
	 * The option premium amount payable by buyer to seller on the specified payment date.
	 */
	List<? extends Payment> getPremium();
	Exercise getExercise();
	/**
	 * A set of parameters defining procedures associated with the exercise.
	 */
	ExerciseProcedure getExerciseProcedure();
	/**
	 * The ISDA Calculation Agent responsible for performing duties associated with an optional early termination.
	 */
	CalculationAgent getCalculationAgent();
	/**
	 * If specified, this means that cash settlement is applicable to the transaction and defines the parameters associated with the cash settlement procedure. If not specified, then physical settlement is applicable.
	 */
	CashSettlement getCashSettlement();
	/**
	 * If specified, this defines physical settlement terms which apply to the transaction.
	 */
	SwaptionPhysicalSettlement getPhysicalSettlement();
	/**
	 * Whether the option is a swaption or a swaption straddle.
	 */
	Boolean getSwaptionStraddle();
	/**
	 * The adjusted dates associated with swaption exercise. These dates have been adjusted for any applicable business day convention.
	 */
	SwaptionAdjustedDates getSwaptionAdjustedDates();
	Swap getSwap();

	/*********************** Build Methods  ***********************/
	Swaption build();
	
	Swaption.SwaptionBuilder toBuilder();
	
	static Swaption.SwaptionBuilder builder() {
		return new Swaption.SwaptionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Swaption> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends Swaption> getType() {
		return Swaption.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("productModel"), processor, ProductModel.class, getProductModel());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("buyerSellerModel"), processor, BuyerSellerModel.class, getBuyerSellerModel());
		processRosetta(path.newSubPath("premium"), processor, Payment.class, getPremium());
		processRosetta(path.newSubPath("exercise"), processor, Exercise.class, getExercise());
		processRosetta(path.newSubPath("exerciseProcedure"), processor, ExerciseProcedure.class, getExerciseProcedure());
		processRosetta(path.newSubPath("calculationAgent"), processor, CalculationAgent.class, getCalculationAgent());
		processRosetta(path.newSubPath("cashSettlement"), processor, CashSettlement.class, getCashSettlement());
		processRosetta(path.newSubPath("physicalSettlement"), processor, SwaptionPhysicalSettlement.class, getPhysicalSettlement());
		processor.processBasic(path.newSubPath("swaptionStraddle"), Boolean.class, getSwaptionStraddle(), this);
		processRosetta(path.newSubPath("swaptionAdjustedDates"), processor, SwaptionAdjustedDates.class, getSwaptionAdjustedDates());
		processRosetta(path.newSubPath("swap"), processor, Swap.class, getSwap());
	}
	

	/*********************** Builder Interface  ***********************/
	interface SwaptionBuilder extends Swaption, Product.ProductBuilder {
		BuyerSellerModel.BuyerSellerModelBuilder getOrCreateBuyerSellerModel();
		BuyerSellerModel.BuyerSellerModelBuilder getBuyerSellerModel();
		Payment.PaymentBuilder getOrCreatePremium(int _index);
		List<? extends Payment.PaymentBuilder> getPremium();
		Exercise.ExerciseBuilder getOrCreateExercise();
		Exercise.ExerciseBuilder getExercise();
		ExerciseProcedure.ExerciseProcedureBuilder getOrCreateExerciseProcedure();
		ExerciseProcedure.ExerciseProcedureBuilder getExerciseProcedure();
		CalculationAgent.CalculationAgentBuilder getOrCreateCalculationAgent();
		CalculationAgent.CalculationAgentBuilder getCalculationAgent();
		CashSettlement.CashSettlementBuilder getOrCreateCashSettlement();
		CashSettlement.CashSettlementBuilder getCashSettlement();
		SwaptionPhysicalSettlement.SwaptionPhysicalSettlementBuilder getOrCreatePhysicalSettlement();
		SwaptionPhysicalSettlement.SwaptionPhysicalSettlementBuilder getPhysicalSettlement();
		SwaptionAdjustedDates.SwaptionAdjustedDatesBuilder getOrCreateSwaptionAdjustedDates();
		SwaptionAdjustedDates.SwaptionAdjustedDatesBuilder getSwaptionAdjustedDates();
		Swap.SwapBuilder getOrCreateSwap();
		Swap.SwapBuilder getSwap();
		Swaption.SwaptionBuilder setProductModel(ProductModel productModel);
		Swaption.SwaptionBuilder setId(String id);
		Swaption.SwaptionBuilder setBuyerSellerModel(BuyerSellerModel buyerSellerModel);
		Swaption.SwaptionBuilder addPremium(Payment premium0);
		Swaption.SwaptionBuilder addPremium(Payment premium1, int _idx);
		Swaption.SwaptionBuilder addPremium(List<? extends Payment> premium2);
		Swaption.SwaptionBuilder setPremium(List<? extends Payment> premium3);
		Swaption.SwaptionBuilder setExercise(Exercise exercise);
		Swaption.SwaptionBuilder setExerciseProcedure(ExerciseProcedure exerciseProcedure);
		Swaption.SwaptionBuilder setCalculationAgent(CalculationAgent calculationAgent);
		Swaption.SwaptionBuilder setCashSettlement(CashSettlement cashSettlement);
		Swaption.SwaptionBuilder setPhysicalSettlement(SwaptionPhysicalSettlement physicalSettlement);
		Swaption.SwaptionBuilder setSwaptionStraddle(Boolean swaptionStraddle);
		Swaption.SwaptionBuilder setSwaptionAdjustedDates(SwaptionAdjustedDates swaptionAdjustedDates);
		Swaption.SwaptionBuilder setSwap(Swap swap);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("productModel"), processor, ProductModel.ProductModelBuilder.class, getProductModel());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("buyerSellerModel"), processor, BuyerSellerModel.BuyerSellerModelBuilder.class, getBuyerSellerModel());
			processRosetta(path.newSubPath("premium"), processor, Payment.PaymentBuilder.class, getPremium());
			processRosetta(path.newSubPath("exercise"), processor, Exercise.ExerciseBuilder.class, getExercise());
			processRosetta(path.newSubPath("exerciseProcedure"), processor, ExerciseProcedure.ExerciseProcedureBuilder.class, getExerciseProcedure());
			processRosetta(path.newSubPath("calculationAgent"), processor, CalculationAgent.CalculationAgentBuilder.class, getCalculationAgent());
			processRosetta(path.newSubPath("cashSettlement"), processor, CashSettlement.CashSettlementBuilder.class, getCashSettlement());
			processRosetta(path.newSubPath("physicalSettlement"), processor, SwaptionPhysicalSettlement.SwaptionPhysicalSettlementBuilder.class, getPhysicalSettlement());
			processor.processBasic(path.newSubPath("swaptionStraddle"), Boolean.class, getSwaptionStraddle(), this);
			processRosetta(path.newSubPath("swaptionAdjustedDates"), processor, SwaptionAdjustedDates.SwaptionAdjustedDatesBuilder.class, getSwaptionAdjustedDates());
			processRosetta(path.newSubPath("swap"), processor, Swap.SwapBuilder.class, getSwap());
		}
		

		Swaption.SwaptionBuilder prune();
	}

	/*********************** Immutable Implementation of Swaption  ***********************/
	class SwaptionImpl extends Product.ProductImpl implements Swaption {
		private final BuyerSellerModel buyerSellerModel;
		private final List<? extends Payment> premium;
		private final Exercise exercise;
		private final ExerciseProcedure exerciseProcedure;
		private final CalculationAgent calculationAgent;
		private final CashSettlement cashSettlement;
		private final SwaptionPhysicalSettlement physicalSettlement;
		private final Boolean swaptionStraddle;
		private final SwaptionAdjustedDates swaptionAdjustedDates;
		private final Swap swap;
		
		protected SwaptionImpl(Swaption.SwaptionBuilder builder) {
			super(builder);
			this.buyerSellerModel = ofNullable(builder.getBuyerSellerModel()).map(f->f.build()).orElse(null);
			this.premium = ofNullable(builder.getPremium()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.exercise = ofNullable(builder.getExercise()).map(f->f.build()).orElse(null);
			this.exerciseProcedure = ofNullable(builder.getExerciseProcedure()).map(f->f.build()).orElse(null);
			this.calculationAgent = ofNullable(builder.getCalculationAgent()).map(f->f.build()).orElse(null);
			this.cashSettlement = ofNullable(builder.getCashSettlement()).map(f->f.build()).orElse(null);
			this.physicalSettlement = ofNullable(builder.getPhysicalSettlement()).map(f->f.build()).orElse(null);
			this.swaptionStraddle = builder.getSwaptionStraddle();
			this.swaptionAdjustedDates = ofNullable(builder.getSwaptionAdjustedDates()).map(f->f.build()).orElse(null);
			this.swap = ofNullable(builder.getSwap()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("buyerSellerModel")
		public BuyerSellerModel getBuyerSellerModel() {
			return buyerSellerModel;
		}
		
		@Override
		@RosettaAttribute("premium")
		public List<? extends Payment> getPremium() {
			return premium;
		}
		
		@Override
		@RosettaAttribute("exercise")
		public Exercise getExercise() {
			return exercise;
		}
		
		@Override
		@RosettaAttribute("exerciseProcedure")
		public ExerciseProcedure getExerciseProcedure() {
			return exerciseProcedure;
		}
		
		@Override
		@RosettaAttribute("calculationAgent")
		public CalculationAgent getCalculationAgent() {
			return calculationAgent;
		}
		
		@Override
		@RosettaAttribute("cashSettlement")
		public CashSettlement getCashSettlement() {
			return cashSettlement;
		}
		
		@Override
		@RosettaAttribute("physicalSettlement")
		public SwaptionPhysicalSettlement getPhysicalSettlement() {
			return physicalSettlement;
		}
		
		@Override
		@RosettaAttribute("swaptionStraddle")
		public Boolean getSwaptionStraddle() {
			return swaptionStraddle;
		}
		
		@Override
		@RosettaAttribute("swaptionAdjustedDates")
		public SwaptionAdjustedDates getSwaptionAdjustedDates() {
			return swaptionAdjustedDates;
		}
		
		@Override
		@RosettaAttribute("swap")
		public Swap getSwap() {
			return swap;
		}
		
		@Override
		public Swaption build() {
			return this;
		}
		
		@Override
		public Swaption.SwaptionBuilder toBuilder() {
			Swaption.SwaptionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Swaption.SwaptionBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getBuyerSellerModel()).ifPresent(builder::setBuyerSellerModel);
			ofNullable(getPremium()).ifPresent(builder::setPremium);
			ofNullable(getExercise()).ifPresent(builder::setExercise);
			ofNullable(getExerciseProcedure()).ifPresent(builder::setExerciseProcedure);
			ofNullable(getCalculationAgent()).ifPresent(builder::setCalculationAgent);
			ofNullable(getCashSettlement()).ifPresent(builder::setCashSettlement);
			ofNullable(getPhysicalSettlement()).ifPresent(builder::setPhysicalSettlement);
			ofNullable(getSwaptionStraddle()).ifPresent(builder::setSwaptionStraddle);
			ofNullable(getSwaptionAdjustedDates()).ifPresent(builder::setSwaptionAdjustedDates);
			ofNullable(getSwap()).ifPresent(builder::setSwap);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Swaption _that = getType().cast(o);
		
			if (!Objects.equals(buyerSellerModel, _that.getBuyerSellerModel())) return false;
			if (!ListEquals.listEquals(premium, _that.getPremium())) return false;
			if (!Objects.equals(exercise, _that.getExercise())) return false;
			if (!Objects.equals(exerciseProcedure, _that.getExerciseProcedure())) return false;
			if (!Objects.equals(calculationAgent, _that.getCalculationAgent())) return false;
			if (!Objects.equals(cashSettlement, _that.getCashSettlement())) return false;
			if (!Objects.equals(physicalSettlement, _that.getPhysicalSettlement())) return false;
			if (!Objects.equals(swaptionStraddle, _that.getSwaptionStraddle())) return false;
			if (!Objects.equals(swaptionAdjustedDates, _that.getSwaptionAdjustedDates())) return false;
			if (!Objects.equals(swap, _that.getSwap())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (buyerSellerModel != null ? buyerSellerModel.hashCode() : 0);
			_result = 31 * _result + (premium != null ? premium.hashCode() : 0);
			_result = 31 * _result + (exercise != null ? exercise.hashCode() : 0);
			_result = 31 * _result + (exerciseProcedure != null ? exerciseProcedure.hashCode() : 0);
			_result = 31 * _result + (calculationAgent != null ? calculationAgent.hashCode() : 0);
			_result = 31 * _result + (cashSettlement != null ? cashSettlement.hashCode() : 0);
			_result = 31 * _result + (physicalSettlement != null ? physicalSettlement.hashCode() : 0);
			_result = 31 * _result + (swaptionStraddle != null ? swaptionStraddle.hashCode() : 0);
			_result = 31 * _result + (swaptionAdjustedDates != null ? swaptionAdjustedDates.hashCode() : 0);
			_result = 31 * _result + (swap != null ? swap.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Swaption {" +
				"buyerSellerModel=" + this.buyerSellerModel + ", " +
				"premium=" + this.premium + ", " +
				"exercise=" + this.exercise + ", " +
				"exerciseProcedure=" + this.exerciseProcedure + ", " +
				"calculationAgent=" + this.calculationAgent + ", " +
				"cashSettlement=" + this.cashSettlement + ", " +
				"physicalSettlement=" + this.physicalSettlement + ", " +
				"swaptionStraddle=" + this.swaptionStraddle + ", " +
				"swaptionAdjustedDates=" + this.swaptionAdjustedDates + ", " +
				"swap=" + this.swap +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of Swaption  ***********************/
	class SwaptionBuilderImpl extends Product.ProductBuilderImpl  implements Swaption.SwaptionBuilder {
	
		protected BuyerSellerModel.BuyerSellerModelBuilder buyerSellerModel;
		protected List<Payment.PaymentBuilder> premium = new ArrayList<>();
		protected Exercise.ExerciseBuilder exercise;
		protected ExerciseProcedure.ExerciseProcedureBuilder exerciseProcedure;
		protected CalculationAgent.CalculationAgentBuilder calculationAgent;
		protected CashSettlement.CashSettlementBuilder cashSettlement;
		protected SwaptionPhysicalSettlement.SwaptionPhysicalSettlementBuilder physicalSettlement;
		protected Boolean swaptionStraddle;
		protected SwaptionAdjustedDates.SwaptionAdjustedDatesBuilder swaptionAdjustedDates;
		protected Swap.SwapBuilder swap;
	
		public SwaptionBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("buyerSellerModel")
		public BuyerSellerModel.BuyerSellerModelBuilder getBuyerSellerModel() {
			return buyerSellerModel;
		}
		
		@Override
		public BuyerSellerModel.BuyerSellerModelBuilder getOrCreateBuyerSellerModel() {
			BuyerSellerModel.BuyerSellerModelBuilder result;
			if (buyerSellerModel!=null) {
				result = buyerSellerModel;
			}
			else {
				result = buyerSellerModel = BuyerSellerModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("premium")
		public List<? extends Payment.PaymentBuilder> getPremium() {
			return premium;
		}
		
		@Override
		public Payment.PaymentBuilder getOrCreatePremium(int _index) {
		
			if (premium==null) {
				this.premium = new ArrayList<>();
			}
			Payment.PaymentBuilder result;
			return getIndex(premium, _index, () -> {
						Payment.PaymentBuilder newPremium = Payment.builder();
						return newPremium;
					});
		}
		
		@Override
		@RosettaAttribute("exercise")
		public Exercise.ExerciseBuilder getExercise() {
			return exercise;
		}
		
		@Override
		public Exercise.ExerciseBuilder getOrCreateExercise() {
			Exercise.ExerciseBuilder result;
			if (exercise!=null) {
				result = exercise;
			}
			else {
				result = exercise = Exercise.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("exerciseProcedure")
		public ExerciseProcedure.ExerciseProcedureBuilder getExerciseProcedure() {
			return exerciseProcedure;
		}
		
		@Override
		public ExerciseProcedure.ExerciseProcedureBuilder getOrCreateExerciseProcedure() {
			ExerciseProcedure.ExerciseProcedureBuilder result;
			if (exerciseProcedure!=null) {
				result = exerciseProcedure;
			}
			else {
				result = exerciseProcedure = ExerciseProcedure.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("calculationAgent")
		public CalculationAgent.CalculationAgentBuilder getCalculationAgent() {
			return calculationAgent;
		}
		
		@Override
		public CalculationAgent.CalculationAgentBuilder getOrCreateCalculationAgent() {
			CalculationAgent.CalculationAgentBuilder result;
			if (calculationAgent!=null) {
				result = calculationAgent;
			}
			else {
				result = calculationAgent = CalculationAgent.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("cashSettlement")
		public CashSettlement.CashSettlementBuilder getCashSettlement() {
			return cashSettlement;
		}
		
		@Override
		public CashSettlement.CashSettlementBuilder getOrCreateCashSettlement() {
			CashSettlement.CashSettlementBuilder result;
			if (cashSettlement!=null) {
				result = cashSettlement;
			}
			else {
				result = cashSettlement = CashSettlement.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("physicalSettlement")
		public SwaptionPhysicalSettlement.SwaptionPhysicalSettlementBuilder getPhysicalSettlement() {
			return physicalSettlement;
		}
		
		@Override
		public SwaptionPhysicalSettlement.SwaptionPhysicalSettlementBuilder getOrCreatePhysicalSettlement() {
			SwaptionPhysicalSettlement.SwaptionPhysicalSettlementBuilder result;
			if (physicalSettlement!=null) {
				result = physicalSettlement;
			}
			else {
				result = physicalSettlement = SwaptionPhysicalSettlement.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("swaptionStraddle")
		public Boolean getSwaptionStraddle() {
			return swaptionStraddle;
		}
		
		@Override
		@RosettaAttribute("swaptionAdjustedDates")
		public SwaptionAdjustedDates.SwaptionAdjustedDatesBuilder getSwaptionAdjustedDates() {
			return swaptionAdjustedDates;
		}
		
		@Override
		public SwaptionAdjustedDates.SwaptionAdjustedDatesBuilder getOrCreateSwaptionAdjustedDates() {
			SwaptionAdjustedDates.SwaptionAdjustedDatesBuilder result;
			if (swaptionAdjustedDates!=null) {
				result = swaptionAdjustedDates;
			}
			else {
				result = swaptionAdjustedDates = SwaptionAdjustedDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("swap")
		public Swap.SwapBuilder getSwap() {
			return swap;
		}
		
		@Override
		public Swap.SwapBuilder getOrCreateSwap() {
			Swap.SwapBuilder result;
			if (swap!=null) {
				result = swap;
			}
			else {
				result = swap = Swap.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("productModel")
		public Swaption.SwaptionBuilder setProductModel(ProductModel productModel) {
			this.productModel = productModel==null?null:productModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public Swaption.SwaptionBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("buyerSellerModel")
		public Swaption.SwaptionBuilder setBuyerSellerModel(BuyerSellerModel buyerSellerModel) {
			this.buyerSellerModel = buyerSellerModel==null?null:buyerSellerModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("premium")
		public Swaption.SwaptionBuilder addPremium(Payment premium) {
			if (premium!=null) this.premium.add(premium.toBuilder());
			return this;
		}
		
		@Override
		public Swaption.SwaptionBuilder addPremium(Payment premium, int _idx) {
			getIndex(this.premium, _idx, () -> premium.toBuilder());
			return this;
		}
		@Override 
		public Swaption.SwaptionBuilder addPremium(List<? extends Payment> premiums) {
			if (premiums != null) {
				for (Payment toAdd : premiums) {
					this.premium.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public Swaption.SwaptionBuilder setPremium(List<? extends Payment> premiums) {
			if (premiums == null)  {
				this.premium = new ArrayList<>();
			}
			else {
				this.premium = premiums.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("exercise")
		public Swaption.SwaptionBuilder setExercise(Exercise exercise) {
			this.exercise = exercise==null?null:exercise.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("exerciseProcedure")
		public Swaption.SwaptionBuilder setExerciseProcedure(ExerciseProcedure exerciseProcedure) {
			this.exerciseProcedure = exerciseProcedure==null?null:exerciseProcedure.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("calculationAgent")
		public Swaption.SwaptionBuilder setCalculationAgent(CalculationAgent calculationAgent) {
			this.calculationAgent = calculationAgent==null?null:calculationAgent.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("cashSettlement")
		public Swaption.SwaptionBuilder setCashSettlement(CashSettlement cashSettlement) {
			this.cashSettlement = cashSettlement==null?null:cashSettlement.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("physicalSettlement")
		public Swaption.SwaptionBuilder setPhysicalSettlement(SwaptionPhysicalSettlement physicalSettlement) {
			this.physicalSettlement = physicalSettlement==null?null:physicalSettlement.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("swaptionStraddle")
		public Swaption.SwaptionBuilder setSwaptionStraddle(Boolean swaptionStraddle) {
			this.swaptionStraddle = swaptionStraddle==null?null:swaptionStraddle;
			return this;
		}
		@Override
		@RosettaAttribute("swaptionAdjustedDates")
		public Swaption.SwaptionBuilder setSwaptionAdjustedDates(SwaptionAdjustedDates swaptionAdjustedDates) {
			this.swaptionAdjustedDates = swaptionAdjustedDates==null?null:swaptionAdjustedDates.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("swap")
		public Swaption.SwaptionBuilder setSwap(Swap swap) {
			this.swap = swap==null?null:swap.toBuilder();
			return this;
		}
		
		@Override
		public Swaption build() {
			return new Swaption.SwaptionImpl(this);
		}
		
		@Override
		public Swaption.SwaptionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Swaption.SwaptionBuilder prune() {
			super.prune();
			if (buyerSellerModel!=null && !buyerSellerModel.prune().hasData()) buyerSellerModel = null;
			premium = premium.stream().filter(b->b!=null).<Payment.PaymentBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (exercise!=null && !exercise.prune().hasData()) exercise = null;
			if (exerciseProcedure!=null && !exerciseProcedure.prune().hasData()) exerciseProcedure = null;
			if (calculationAgent!=null && !calculationAgent.prune().hasData()) calculationAgent = null;
			if (cashSettlement!=null && !cashSettlement.prune().hasData()) cashSettlement = null;
			if (physicalSettlement!=null && !physicalSettlement.prune().hasData()) physicalSettlement = null;
			if (swaptionAdjustedDates!=null && !swaptionAdjustedDates.prune().hasData()) swaptionAdjustedDates = null;
			if (swap!=null && !swap.prune().hasData()) swap = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getBuyerSellerModel()!=null && getBuyerSellerModel().hasData()) return true;
			if (getPremium()!=null && getPremium().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getExercise()!=null && getExercise().hasData()) return true;
			if (getExerciseProcedure()!=null && getExerciseProcedure().hasData()) return true;
			if (getCalculationAgent()!=null && getCalculationAgent().hasData()) return true;
			if (getCashSettlement()!=null && getCashSettlement().hasData()) return true;
			if (getPhysicalSettlement()!=null && getPhysicalSettlement().hasData()) return true;
			if (getSwaptionStraddle()!=null) return true;
			if (getSwaptionAdjustedDates()!=null && getSwaptionAdjustedDates().hasData()) return true;
			if (getSwap()!=null && getSwap().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Swaption.SwaptionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			Swaption.SwaptionBuilder o = (Swaption.SwaptionBuilder) other;
			
			merger.mergeRosetta(getBuyerSellerModel(), o.getBuyerSellerModel(), this::setBuyerSellerModel);
			merger.mergeRosetta(getPremium(), o.getPremium(), this::getOrCreatePremium);
			merger.mergeRosetta(getExercise(), o.getExercise(), this::setExercise);
			merger.mergeRosetta(getExerciseProcedure(), o.getExerciseProcedure(), this::setExerciseProcedure);
			merger.mergeRosetta(getCalculationAgent(), o.getCalculationAgent(), this::setCalculationAgent);
			merger.mergeRosetta(getCashSettlement(), o.getCashSettlement(), this::setCashSettlement);
			merger.mergeRosetta(getPhysicalSettlement(), o.getPhysicalSettlement(), this::setPhysicalSettlement);
			merger.mergeRosetta(getSwaptionAdjustedDates(), o.getSwaptionAdjustedDates(), this::setSwaptionAdjustedDates);
			merger.mergeRosetta(getSwap(), o.getSwap(), this::setSwap);
			
			merger.mergeBasic(getSwaptionStraddle(), o.getSwaptionStraddle(), this::setSwaptionStraddle);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Swaption _that = getType().cast(o);
		
			if (!Objects.equals(buyerSellerModel, _that.getBuyerSellerModel())) return false;
			if (!ListEquals.listEquals(premium, _that.getPremium())) return false;
			if (!Objects.equals(exercise, _that.getExercise())) return false;
			if (!Objects.equals(exerciseProcedure, _that.getExerciseProcedure())) return false;
			if (!Objects.equals(calculationAgent, _that.getCalculationAgent())) return false;
			if (!Objects.equals(cashSettlement, _that.getCashSettlement())) return false;
			if (!Objects.equals(physicalSettlement, _that.getPhysicalSettlement())) return false;
			if (!Objects.equals(swaptionStraddle, _that.getSwaptionStraddle())) return false;
			if (!Objects.equals(swaptionAdjustedDates, _that.getSwaptionAdjustedDates())) return false;
			if (!Objects.equals(swap, _that.getSwap())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (buyerSellerModel != null ? buyerSellerModel.hashCode() : 0);
			_result = 31 * _result + (premium != null ? premium.hashCode() : 0);
			_result = 31 * _result + (exercise != null ? exercise.hashCode() : 0);
			_result = 31 * _result + (exerciseProcedure != null ? exerciseProcedure.hashCode() : 0);
			_result = 31 * _result + (calculationAgent != null ? calculationAgent.hashCode() : 0);
			_result = 31 * _result + (cashSettlement != null ? cashSettlement.hashCode() : 0);
			_result = 31 * _result + (physicalSettlement != null ? physicalSettlement.hashCode() : 0);
			_result = 31 * _result + (swaptionStraddle != null ? swaptionStraddle.hashCode() : 0);
			_result = 31 * _result + (swaptionAdjustedDates != null ? swaptionAdjustedDates.hashCode() : 0);
			_result = 31 * _result + (swap != null ? swap.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SwaptionBuilder {" +
				"buyerSellerModel=" + this.buyerSellerModel + ", " +
				"premium=" + this.premium + ", " +
				"exercise=" + this.exercise + ", " +
				"exerciseProcedure=" + this.exerciseProcedure + ", " +
				"calculationAgent=" + this.calculationAgent + ", " +
				"cashSettlement=" + this.cashSettlement + ", " +
				"physicalSettlement=" + this.physicalSettlement + ", " +
				"swaptionStraddle=" + this.swaptionStraddle + ", " +
				"swaptionAdjustedDates=" + this.swaptionAdjustedDates + ", " +
				"swap=" + this.swap +
			'}' + " " + super.toString();
		}
	}
}
