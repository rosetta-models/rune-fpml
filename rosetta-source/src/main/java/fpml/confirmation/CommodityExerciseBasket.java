package fpml.confirmation;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.confirmation.CommodityAmericanExercise;
import fpml.confirmation.CommodityEuropeanExercise;
import fpml.confirmation.CommodityExerciseBasket;
import fpml.confirmation.CommodityExerciseBasket.CommodityExerciseBasketBuilder;
import fpml.confirmation.CommodityExerciseBasket.CommodityExerciseBasketBuilderImpl;
import fpml.confirmation.CommodityExerciseBasket.CommodityExerciseBasketImpl;
import fpml.confirmation.CommodityPaymentDatesModel;
import fpml.confirmation.IdentifiedCurrency;
import fpml.confirmation.meta.CommodityExerciseBasketMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The parameters for defining how the commodity option can be exercised, how it is priced and how it is settled.
 * @version ${project.version}
 */
@RosettaDataType(value="CommodityExerciseBasket", builder=CommodityExerciseBasket.CommodityExerciseBasketBuilderImpl.class, version="${project.version}")
public interface CommodityExerciseBasket extends RosettaModelObject {

	CommodityExerciseBasketMeta metaData = new CommodityExerciseBasketMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The parameters for defining the exercise period for an American style option together with the rules governing the quantity of the commodity that can be exercised on any given exercise date.
	 */
	CommodityAmericanExercise getAmericanExercise();
	/**
	 * The parameters for defining the expiration date and time for a European or Asian style option. For an Asian style option the expiration date is equivalent to the termination date.
	 */
	CommodityEuropeanExercise getEuropeanExercise();
	/**
	 * Specifies whether or not Automatic Exercise applies to a Commodity Option Transaction.
	 */
	Boolean getAutomaticExercise();
	/**
	 * Specifies whether or not Written Confirmation applies to a Commodity Option Transaction.
	 */
	Boolean getWrittenConfirmation();
	/**
	 * The currency into which the Commodity Option Transaction will settle. If this is not the same as the currency in which the Commodity Reference Price is quoted, then an FX determination method should also be specified.
	 */
	IdentifiedCurrency getSettlementCurrency();
	CommodityPaymentDatesModel getCommodityPaymentDatesModel();

	/*********************** Build Methods  ***********************/
	CommodityExerciseBasket build();
	
	CommodityExerciseBasket.CommodityExerciseBasketBuilder toBuilder();
	
	static CommodityExerciseBasket.CommodityExerciseBasketBuilder builder() {
		return new CommodityExerciseBasket.CommodityExerciseBasketBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityExerciseBasket> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityExerciseBasket> getType() {
		return CommodityExerciseBasket.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("americanExercise"), processor, CommodityAmericanExercise.class, getAmericanExercise());
		processRosetta(path.newSubPath("europeanExercise"), processor, CommodityEuropeanExercise.class, getEuropeanExercise());
		processor.processBasic(path.newSubPath("automaticExercise"), Boolean.class, getAutomaticExercise(), this);
		processor.processBasic(path.newSubPath("writtenConfirmation"), Boolean.class, getWrittenConfirmation(), this);
		processRosetta(path.newSubPath("settlementCurrency"), processor, IdentifiedCurrency.class, getSettlementCurrency());
		processRosetta(path.newSubPath("commodityPaymentDatesModel"), processor, CommodityPaymentDatesModel.class, getCommodityPaymentDatesModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityExerciseBasketBuilder extends CommodityExerciseBasket, RosettaModelObjectBuilder {
		CommodityAmericanExercise.CommodityAmericanExerciseBuilder getOrCreateAmericanExercise();
		CommodityAmericanExercise.CommodityAmericanExerciseBuilder getAmericanExercise();
		CommodityEuropeanExercise.CommodityEuropeanExerciseBuilder getOrCreateEuropeanExercise();
		CommodityEuropeanExercise.CommodityEuropeanExerciseBuilder getEuropeanExercise();
		IdentifiedCurrency.IdentifiedCurrencyBuilder getOrCreateSettlementCurrency();
		IdentifiedCurrency.IdentifiedCurrencyBuilder getSettlementCurrency();
		CommodityPaymentDatesModel.CommodityPaymentDatesModelBuilder getOrCreateCommodityPaymentDatesModel();
		CommodityPaymentDatesModel.CommodityPaymentDatesModelBuilder getCommodityPaymentDatesModel();
		CommodityExerciseBasket.CommodityExerciseBasketBuilder setAmericanExercise(CommodityAmericanExercise americanExercise);
		CommodityExerciseBasket.CommodityExerciseBasketBuilder setEuropeanExercise(CommodityEuropeanExercise europeanExercise);
		CommodityExerciseBasket.CommodityExerciseBasketBuilder setAutomaticExercise(Boolean automaticExercise);
		CommodityExerciseBasket.CommodityExerciseBasketBuilder setWrittenConfirmation(Boolean writtenConfirmation);
		CommodityExerciseBasket.CommodityExerciseBasketBuilder setSettlementCurrency(IdentifiedCurrency settlementCurrency);
		CommodityExerciseBasket.CommodityExerciseBasketBuilder setCommodityPaymentDatesModel(CommodityPaymentDatesModel commodityPaymentDatesModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("americanExercise"), processor, CommodityAmericanExercise.CommodityAmericanExerciseBuilder.class, getAmericanExercise());
			processRosetta(path.newSubPath("europeanExercise"), processor, CommodityEuropeanExercise.CommodityEuropeanExerciseBuilder.class, getEuropeanExercise());
			processor.processBasic(path.newSubPath("automaticExercise"), Boolean.class, getAutomaticExercise(), this);
			processor.processBasic(path.newSubPath("writtenConfirmation"), Boolean.class, getWrittenConfirmation(), this);
			processRosetta(path.newSubPath("settlementCurrency"), processor, IdentifiedCurrency.IdentifiedCurrencyBuilder.class, getSettlementCurrency());
			processRosetta(path.newSubPath("commodityPaymentDatesModel"), processor, CommodityPaymentDatesModel.CommodityPaymentDatesModelBuilder.class, getCommodityPaymentDatesModel());
		}
		

		CommodityExerciseBasket.CommodityExerciseBasketBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityExerciseBasket  ***********************/
	class CommodityExerciseBasketImpl implements CommodityExerciseBasket {
		private final CommodityAmericanExercise americanExercise;
		private final CommodityEuropeanExercise europeanExercise;
		private final Boolean automaticExercise;
		private final Boolean writtenConfirmation;
		private final IdentifiedCurrency settlementCurrency;
		private final CommodityPaymentDatesModel commodityPaymentDatesModel;
		
		protected CommodityExerciseBasketImpl(CommodityExerciseBasket.CommodityExerciseBasketBuilder builder) {
			this.americanExercise = ofNullable(builder.getAmericanExercise()).map(f->f.build()).orElse(null);
			this.europeanExercise = ofNullable(builder.getEuropeanExercise()).map(f->f.build()).orElse(null);
			this.automaticExercise = builder.getAutomaticExercise();
			this.writtenConfirmation = builder.getWrittenConfirmation();
			this.settlementCurrency = ofNullable(builder.getSettlementCurrency()).map(f->f.build()).orElse(null);
			this.commodityPaymentDatesModel = ofNullable(builder.getCommodityPaymentDatesModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("americanExercise")
		public CommodityAmericanExercise getAmericanExercise() {
			return americanExercise;
		}
		
		@Override
		@RosettaAttribute("europeanExercise")
		public CommodityEuropeanExercise getEuropeanExercise() {
			return europeanExercise;
		}
		
		@Override
		@RosettaAttribute("automaticExercise")
		public Boolean getAutomaticExercise() {
			return automaticExercise;
		}
		
		@Override
		@RosettaAttribute("writtenConfirmation")
		public Boolean getWrittenConfirmation() {
			return writtenConfirmation;
		}
		
		@Override
		@RosettaAttribute("settlementCurrency")
		public IdentifiedCurrency getSettlementCurrency() {
			return settlementCurrency;
		}
		
		@Override
		@RosettaAttribute("commodityPaymentDatesModel")
		public CommodityPaymentDatesModel getCommodityPaymentDatesModel() {
			return commodityPaymentDatesModel;
		}
		
		@Override
		public CommodityExerciseBasket build() {
			return this;
		}
		
		@Override
		public CommodityExerciseBasket.CommodityExerciseBasketBuilder toBuilder() {
			CommodityExerciseBasket.CommodityExerciseBasketBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityExerciseBasket.CommodityExerciseBasketBuilder builder) {
			ofNullable(getAmericanExercise()).ifPresent(builder::setAmericanExercise);
			ofNullable(getEuropeanExercise()).ifPresent(builder::setEuropeanExercise);
			ofNullable(getAutomaticExercise()).ifPresent(builder::setAutomaticExercise);
			ofNullable(getWrittenConfirmation()).ifPresent(builder::setWrittenConfirmation);
			ofNullable(getSettlementCurrency()).ifPresent(builder::setSettlementCurrency);
			ofNullable(getCommodityPaymentDatesModel()).ifPresent(builder::setCommodityPaymentDatesModel);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityExerciseBasket _that = getType().cast(o);
		
			if (!Objects.equals(americanExercise, _that.getAmericanExercise())) return false;
			if (!Objects.equals(europeanExercise, _that.getEuropeanExercise())) return false;
			if (!Objects.equals(automaticExercise, _that.getAutomaticExercise())) return false;
			if (!Objects.equals(writtenConfirmation, _that.getWrittenConfirmation())) return false;
			if (!Objects.equals(settlementCurrency, _that.getSettlementCurrency())) return false;
			if (!Objects.equals(commodityPaymentDatesModel, _that.getCommodityPaymentDatesModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (americanExercise != null ? americanExercise.hashCode() : 0);
			_result = 31 * _result + (europeanExercise != null ? europeanExercise.hashCode() : 0);
			_result = 31 * _result + (automaticExercise != null ? automaticExercise.hashCode() : 0);
			_result = 31 * _result + (writtenConfirmation != null ? writtenConfirmation.hashCode() : 0);
			_result = 31 * _result + (settlementCurrency != null ? settlementCurrency.hashCode() : 0);
			_result = 31 * _result + (commodityPaymentDatesModel != null ? commodityPaymentDatesModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityExerciseBasket {" +
				"americanExercise=" + this.americanExercise + ", " +
				"europeanExercise=" + this.europeanExercise + ", " +
				"automaticExercise=" + this.automaticExercise + ", " +
				"writtenConfirmation=" + this.writtenConfirmation + ", " +
				"settlementCurrency=" + this.settlementCurrency + ", " +
				"commodityPaymentDatesModel=" + this.commodityPaymentDatesModel +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityExerciseBasket  ***********************/
	class CommodityExerciseBasketBuilderImpl implements CommodityExerciseBasket.CommodityExerciseBasketBuilder {
	
		protected CommodityAmericanExercise.CommodityAmericanExerciseBuilder americanExercise;
		protected CommodityEuropeanExercise.CommodityEuropeanExerciseBuilder europeanExercise;
		protected Boolean automaticExercise;
		protected Boolean writtenConfirmation;
		protected IdentifiedCurrency.IdentifiedCurrencyBuilder settlementCurrency;
		protected CommodityPaymentDatesModel.CommodityPaymentDatesModelBuilder commodityPaymentDatesModel;
	
		public CommodityExerciseBasketBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("americanExercise")
		public CommodityAmericanExercise.CommodityAmericanExerciseBuilder getAmericanExercise() {
			return americanExercise;
		}
		
		@Override
		public CommodityAmericanExercise.CommodityAmericanExerciseBuilder getOrCreateAmericanExercise() {
			CommodityAmericanExercise.CommodityAmericanExerciseBuilder result;
			if (americanExercise!=null) {
				result = americanExercise;
			}
			else {
				result = americanExercise = CommodityAmericanExercise.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("europeanExercise")
		public CommodityEuropeanExercise.CommodityEuropeanExerciseBuilder getEuropeanExercise() {
			return europeanExercise;
		}
		
		@Override
		public CommodityEuropeanExercise.CommodityEuropeanExerciseBuilder getOrCreateEuropeanExercise() {
			CommodityEuropeanExercise.CommodityEuropeanExerciseBuilder result;
			if (europeanExercise!=null) {
				result = europeanExercise;
			}
			else {
				result = europeanExercise = CommodityEuropeanExercise.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("automaticExercise")
		public Boolean getAutomaticExercise() {
			return automaticExercise;
		}
		
		@Override
		@RosettaAttribute("writtenConfirmation")
		public Boolean getWrittenConfirmation() {
			return writtenConfirmation;
		}
		
		@Override
		@RosettaAttribute("settlementCurrency")
		public IdentifiedCurrency.IdentifiedCurrencyBuilder getSettlementCurrency() {
			return settlementCurrency;
		}
		
		@Override
		public IdentifiedCurrency.IdentifiedCurrencyBuilder getOrCreateSettlementCurrency() {
			IdentifiedCurrency.IdentifiedCurrencyBuilder result;
			if (settlementCurrency!=null) {
				result = settlementCurrency;
			}
			else {
				result = settlementCurrency = IdentifiedCurrency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("commodityPaymentDatesModel")
		public CommodityPaymentDatesModel.CommodityPaymentDatesModelBuilder getCommodityPaymentDatesModel() {
			return commodityPaymentDatesModel;
		}
		
		@Override
		public CommodityPaymentDatesModel.CommodityPaymentDatesModelBuilder getOrCreateCommodityPaymentDatesModel() {
			CommodityPaymentDatesModel.CommodityPaymentDatesModelBuilder result;
			if (commodityPaymentDatesModel!=null) {
				result = commodityPaymentDatesModel;
			}
			else {
				result = commodityPaymentDatesModel = CommodityPaymentDatesModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("americanExercise")
		public CommodityExerciseBasket.CommodityExerciseBasketBuilder setAmericanExercise(CommodityAmericanExercise americanExercise) {
			this.americanExercise = americanExercise==null?null:americanExercise.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("europeanExercise")
		public CommodityExerciseBasket.CommodityExerciseBasketBuilder setEuropeanExercise(CommodityEuropeanExercise europeanExercise) {
			this.europeanExercise = europeanExercise==null?null:europeanExercise.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("automaticExercise")
		public CommodityExerciseBasket.CommodityExerciseBasketBuilder setAutomaticExercise(Boolean automaticExercise) {
			this.automaticExercise = automaticExercise==null?null:automaticExercise;
			return this;
		}
		@Override
		@RosettaAttribute("writtenConfirmation")
		public CommodityExerciseBasket.CommodityExerciseBasketBuilder setWrittenConfirmation(Boolean writtenConfirmation) {
			this.writtenConfirmation = writtenConfirmation==null?null:writtenConfirmation;
			return this;
		}
		@Override
		@RosettaAttribute("settlementCurrency")
		public CommodityExerciseBasket.CommodityExerciseBasketBuilder setSettlementCurrency(IdentifiedCurrency settlementCurrency) {
			this.settlementCurrency = settlementCurrency==null?null:settlementCurrency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("commodityPaymentDatesModel")
		public CommodityExerciseBasket.CommodityExerciseBasketBuilder setCommodityPaymentDatesModel(CommodityPaymentDatesModel commodityPaymentDatesModel) {
			this.commodityPaymentDatesModel = commodityPaymentDatesModel==null?null:commodityPaymentDatesModel.toBuilder();
			return this;
		}
		
		@Override
		public CommodityExerciseBasket build() {
			return new CommodityExerciseBasket.CommodityExerciseBasketImpl(this);
		}
		
		@Override
		public CommodityExerciseBasket.CommodityExerciseBasketBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityExerciseBasket.CommodityExerciseBasketBuilder prune() {
			if (americanExercise!=null && !americanExercise.prune().hasData()) americanExercise = null;
			if (europeanExercise!=null && !europeanExercise.prune().hasData()) europeanExercise = null;
			if (settlementCurrency!=null && !settlementCurrency.prune().hasData()) settlementCurrency = null;
			if (commodityPaymentDatesModel!=null && !commodityPaymentDatesModel.prune().hasData()) commodityPaymentDatesModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAmericanExercise()!=null && getAmericanExercise().hasData()) return true;
			if (getEuropeanExercise()!=null && getEuropeanExercise().hasData()) return true;
			if (getAutomaticExercise()!=null) return true;
			if (getWrittenConfirmation()!=null) return true;
			if (getSettlementCurrency()!=null && getSettlementCurrency().hasData()) return true;
			if (getCommodityPaymentDatesModel()!=null && getCommodityPaymentDatesModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityExerciseBasket.CommodityExerciseBasketBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityExerciseBasket.CommodityExerciseBasketBuilder o = (CommodityExerciseBasket.CommodityExerciseBasketBuilder) other;
			
			merger.mergeRosetta(getAmericanExercise(), o.getAmericanExercise(), this::setAmericanExercise);
			merger.mergeRosetta(getEuropeanExercise(), o.getEuropeanExercise(), this::setEuropeanExercise);
			merger.mergeRosetta(getSettlementCurrency(), o.getSettlementCurrency(), this::setSettlementCurrency);
			merger.mergeRosetta(getCommodityPaymentDatesModel(), o.getCommodityPaymentDatesModel(), this::setCommodityPaymentDatesModel);
			
			merger.mergeBasic(getAutomaticExercise(), o.getAutomaticExercise(), this::setAutomaticExercise);
			merger.mergeBasic(getWrittenConfirmation(), o.getWrittenConfirmation(), this::setWrittenConfirmation);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityExerciseBasket _that = getType().cast(o);
		
			if (!Objects.equals(americanExercise, _that.getAmericanExercise())) return false;
			if (!Objects.equals(europeanExercise, _that.getEuropeanExercise())) return false;
			if (!Objects.equals(automaticExercise, _that.getAutomaticExercise())) return false;
			if (!Objects.equals(writtenConfirmation, _that.getWrittenConfirmation())) return false;
			if (!Objects.equals(settlementCurrency, _that.getSettlementCurrency())) return false;
			if (!Objects.equals(commodityPaymentDatesModel, _that.getCommodityPaymentDatesModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (americanExercise != null ? americanExercise.hashCode() : 0);
			_result = 31 * _result + (europeanExercise != null ? europeanExercise.hashCode() : 0);
			_result = 31 * _result + (automaticExercise != null ? automaticExercise.hashCode() : 0);
			_result = 31 * _result + (writtenConfirmation != null ? writtenConfirmation.hashCode() : 0);
			_result = 31 * _result + (settlementCurrency != null ? settlementCurrency.hashCode() : 0);
			_result = 31 * _result + (commodityPaymentDatesModel != null ? commodityPaymentDatesModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityExerciseBasketBuilder {" +
				"americanExercise=" + this.americanExercise + ", " +
				"europeanExercise=" + this.europeanExercise + ", " +
				"automaticExercise=" + this.automaticExercise + ", " +
				"writtenConfirmation=" + this.writtenConfirmation + ", " +
				"settlementCurrency=" + this.settlementCurrency + ", " +
				"commodityPaymentDatesModel=" + this.commodityPaymentDatesModel +
			'}';
		}
	}
}
