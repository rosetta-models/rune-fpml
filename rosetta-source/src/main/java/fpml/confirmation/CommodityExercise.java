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
import fpml.confirmation.CommodityExercise;
import fpml.confirmation.CommodityExercise.CommodityExerciseBuilder;
import fpml.confirmation.CommodityExercise.CommodityExerciseBuilderImpl;
import fpml.confirmation.CommodityExercise.CommodityExerciseImpl;
import fpml.confirmation.CommodityFx;
import fpml.confirmation.CommodityPaymentDatesModel;
import fpml.confirmation.IdentifiedCurrency;
import fpml.confirmation.meta.CommodityExerciseMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The parameters for defining how the commodity option can be exercised, how it is priced and how it is settled.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="CommodityExercise", builder=CommodityExercise.CommodityExerciseBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface CommodityExercise extends RosettaModelObject {

	CommodityExerciseMeta metaData = new CommodityExerciseMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The parameters for defining the expiration date for an American option.
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
	/**
	 * FX observations to be used to convert the observed Commodity Reference Price to the Settlement Currency.
	 */
	CommodityFx getFx();
	/**
	 * If the Notional Quantity is specified in a unit that does not match the unit in which the Commodity Reference Price is quoted, the scaling or conversion factor used to convert the Commodity Reference Price unit into the Notional Quantity unit should be stated here. If there is no conversion, this element is not intended to be used.
	 */
	BigDecimal getConversionFactor();
	CommodityPaymentDatesModel getCommodityPaymentDatesModel();

	/*********************** Build Methods  ***********************/
	CommodityExercise build();
	
	CommodityExercise.CommodityExerciseBuilder toBuilder();
	
	static CommodityExercise.CommodityExerciseBuilder builder() {
		return new CommodityExercise.CommodityExerciseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityExercise> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityExercise> getType() {
		return CommodityExercise.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("americanExercise"), processor, CommodityAmericanExercise.class, getAmericanExercise());
		processRosetta(path.newSubPath("europeanExercise"), processor, CommodityEuropeanExercise.class, getEuropeanExercise());
		processor.processBasic(path.newSubPath("automaticExercise"), Boolean.class, getAutomaticExercise(), this);
		processor.processBasic(path.newSubPath("writtenConfirmation"), Boolean.class, getWrittenConfirmation(), this);
		processRosetta(path.newSubPath("settlementCurrency"), processor, IdentifiedCurrency.class, getSettlementCurrency());
		processRosetta(path.newSubPath("fx"), processor, CommodityFx.class, getFx());
		processor.processBasic(path.newSubPath("conversionFactor"), BigDecimal.class, getConversionFactor(), this);
		processRosetta(path.newSubPath("commodityPaymentDatesModel"), processor, CommodityPaymentDatesModel.class, getCommodityPaymentDatesModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityExerciseBuilder extends CommodityExercise, RosettaModelObjectBuilder {
		CommodityAmericanExercise.CommodityAmericanExerciseBuilder getOrCreateAmericanExercise();
		CommodityAmericanExercise.CommodityAmericanExerciseBuilder getAmericanExercise();
		CommodityEuropeanExercise.CommodityEuropeanExerciseBuilder getOrCreateEuropeanExercise();
		CommodityEuropeanExercise.CommodityEuropeanExerciseBuilder getEuropeanExercise();
		IdentifiedCurrency.IdentifiedCurrencyBuilder getOrCreateSettlementCurrency();
		IdentifiedCurrency.IdentifiedCurrencyBuilder getSettlementCurrency();
		CommodityFx.CommodityFxBuilder getOrCreateFx();
		CommodityFx.CommodityFxBuilder getFx();
		CommodityPaymentDatesModel.CommodityPaymentDatesModelBuilder getOrCreateCommodityPaymentDatesModel();
		CommodityPaymentDatesModel.CommodityPaymentDatesModelBuilder getCommodityPaymentDatesModel();
		CommodityExercise.CommodityExerciseBuilder setAmericanExercise(CommodityAmericanExercise americanExercise);
		CommodityExercise.CommodityExerciseBuilder setEuropeanExercise(CommodityEuropeanExercise europeanExercise);
		CommodityExercise.CommodityExerciseBuilder setAutomaticExercise(Boolean automaticExercise);
		CommodityExercise.CommodityExerciseBuilder setWrittenConfirmation(Boolean writtenConfirmation);
		CommodityExercise.CommodityExerciseBuilder setSettlementCurrency(IdentifiedCurrency settlementCurrency);
		CommodityExercise.CommodityExerciseBuilder setFx(CommodityFx fx);
		CommodityExercise.CommodityExerciseBuilder setConversionFactor(BigDecimal conversionFactor);
		CommodityExercise.CommodityExerciseBuilder setCommodityPaymentDatesModel(CommodityPaymentDatesModel commodityPaymentDatesModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("americanExercise"), processor, CommodityAmericanExercise.CommodityAmericanExerciseBuilder.class, getAmericanExercise());
			processRosetta(path.newSubPath("europeanExercise"), processor, CommodityEuropeanExercise.CommodityEuropeanExerciseBuilder.class, getEuropeanExercise());
			processor.processBasic(path.newSubPath("automaticExercise"), Boolean.class, getAutomaticExercise(), this);
			processor.processBasic(path.newSubPath("writtenConfirmation"), Boolean.class, getWrittenConfirmation(), this);
			processRosetta(path.newSubPath("settlementCurrency"), processor, IdentifiedCurrency.IdentifiedCurrencyBuilder.class, getSettlementCurrency());
			processRosetta(path.newSubPath("fx"), processor, CommodityFx.CommodityFxBuilder.class, getFx());
			processor.processBasic(path.newSubPath("conversionFactor"), BigDecimal.class, getConversionFactor(), this);
			processRosetta(path.newSubPath("commodityPaymentDatesModel"), processor, CommodityPaymentDatesModel.CommodityPaymentDatesModelBuilder.class, getCommodityPaymentDatesModel());
		}
		

		CommodityExercise.CommodityExerciseBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityExercise  ***********************/
	class CommodityExerciseImpl implements CommodityExercise {
		private final CommodityAmericanExercise americanExercise;
		private final CommodityEuropeanExercise europeanExercise;
		private final Boolean automaticExercise;
		private final Boolean writtenConfirmation;
		private final IdentifiedCurrency settlementCurrency;
		private final CommodityFx fx;
		private final BigDecimal conversionFactor;
		private final CommodityPaymentDatesModel commodityPaymentDatesModel;
		
		protected CommodityExerciseImpl(CommodityExercise.CommodityExerciseBuilder builder) {
			this.americanExercise = ofNullable(builder.getAmericanExercise()).map(f->f.build()).orElse(null);
			this.europeanExercise = ofNullable(builder.getEuropeanExercise()).map(f->f.build()).orElse(null);
			this.automaticExercise = builder.getAutomaticExercise();
			this.writtenConfirmation = builder.getWrittenConfirmation();
			this.settlementCurrency = ofNullable(builder.getSettlementCurrency()).map(f->f.build()).orElse(null);
			this.fx = ofNullable(builder.getFx()).map(f->f.build()).orElse(null);
			this.conversionFactor = builder.getConversionFactor();
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
		@RosettaAttribute("fx")
		public CommodityFx getFx() {
			return fx;
		}
		
		@Override
		@RosettaAttribute("conversionFactor")
		public BigDecimal getConversionFactor() {
			return conversionFactor;
		}
		
		@Override
		@RosettaAttribute("commodityPaymentDatesModel")
		public CommodityPaymentDatesModel getCommodityPaymentDatesModel() {
			return commodityPaymentDatesModel;
		}
		
		@Override
		public CommodityExercise build() {
			return this;
		}
		
		@Override
		public CommodityExercise.CommodityExerciseBuilder toBuilder() {
			CommodityExercise.CommodityExerciseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityExercise.CommodityExerciseBuilder builder) {
			ofNullable(getAmericanExercise()).ifPresent(builder::setAmericanExercise);
			ofNullable(getEuropeanExercise()).ifPresent(builder::setEuropeanExercise);
			ofNullable(getAutomaticExercise()).ifPresent(builder::setAutomaticExercise);
			ofNullable(getWrittenConfirmation()).ifPresent(builder::setWrittenConfirmation);
			ofNullable(getSettlementCurrency()).ifPresent(builder::setSettlementCurrency);
			ofNullable(getFx()).ifPresent(builder::setFx);
			ofNullable(getConversionFactor()).ifPresent(builder::setConversionFactor);
			ofNullable(getCommodityPaymentDatesModel()).ifPresent(builder::setCommodityPaymentDatesModel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityExercise _that = getType().cast(o);
		
			if (!Objects.equals(americanExercise, _that.getAmericanExercise())) return false;
			if (!Objects.equals(europeanExercise, _that.getEuropeanExercise())) return false;
			if (!Objects.equals(automaticExercise, _that.getAutomaticExercise())) return false;
			if (!Objects.equals(writtenConfirmation, _that.getWrittenConfirmation())) return false;
			if (!Objects.equals(settlementCurrency, _that.getSettlementCurrency())) return false;
			if (!Objects.equals(fx, _that.getFx())) return false;
			if (!Objects.equals(conversionFactor, _that.getConversionFactor())) return false;
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
			_result = 31 * _result + (fx != null ? fx.hashCode() : 0);
			_result = 31 * _result + (conversionFactor != null ? conversionFactor.hashCode() : 0);
			_result = 31 * _result + (commodityPaymentDatesModel != null ? commodityPaymentDatesModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityExercise {" +
				"americanExercise=" + this.americanExercise + ", " +
				"europeanExercise=" + this.europeanExercise + ", " +
				"automaticExercise=" + this.automaticExercise + ", " +
				"writtenConfirmation=" + this.writtenConfirmation + ", " +
				"settlementCurrency=" + this.settlementCurrency + ", " +
				"fx=" + this.fx + ", " +
				"conversionFactor=" + this.conversionFactor + ", " +
				"commodityPaymentDatesModel=" + this.commodityPaymentDatesModel +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityExercise  ***********************/
	class CommodityExerciseBuilderImpl implements CommodityExercise.CommodityExerciseBuilder {
	
		protected CommodityAmericanExercise.CommodityAmericanExerciseBuilder americanExercise;
		protected CommodityEuropeanExercise.CommodityEuropeanExerciseBuilder europeanExercise;
		protected Boolean automaticExercise;
		protected Boolean writtenConfirmation;
		protected IdentifiedCurrency.IdentifiedCurrencyBuilder settlementCurrency;
		protected CommodityFx.CommodityFxBuilder fx;
		protected BigDecimal conversionFactor;
		protected CommodityPaymentDatesModel.CommodityPaymentDatesModelBuilder commodityPaymentDatesModel;
	
		public CommodityExerciseBuilderImpl() {
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
		@RosettaAttribute("fx")
		public CommodityFx.CommodityFxBuilder getFx() {
			return fx;
		}
		
		@Override
		public CommodityFx.CommodityFxBuilder getOrCreateFx() {
			CommodityFx.CommodityFxBuilder result;
			if (fx!=null) {
				result = fx;
			}
			else {
				result = fx = CommodityFx.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("conversionFactor")
		public BigDecimal getConversionFactor() {
			return conversionFactor;
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
		public CommodityExercise.CommodityExerciseBuilder setAmericanExercise(CommodityAmericanExercise americanExercise) {
			this.americanExercise = americanExercise==null?null:americanExercise.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("europeanExercise")
		public CommodityExercise.CommodityExerciseBuilder setEuropeanExercise(CommodityEuropeanExercise europeanExercise) {
			this.europeanExercise = europeanExercise==null?null:europeanExercise.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("automaticExercise")
		public CommodityExercise.CommodityExerciseBuilder setAutomaticExercise(Boolean automaticExercise) {
			this.automaticExercise = automaticExercise==null?null:automaticExercise;
			return this;
		}
		@Override
		@RosettaAttribute("writtenConfirmation")
		public CommodityExercise.CommodityExerciseBuilder setWrittenConfirmation(Boolean writtenConfirmation) {
			this.writtenConfirmation = writtenConfirmation==null?null:writtenConfirmation;
			return this;
		}
		@Override
		@RosettaAttribute("settlementCurrency")
		public CommodityExercise.CommodityExerciseBuilder setSettlementCurrency(IdentifiedCurrency settlementCurrency) {
			this.settlementCurrency = settlementCurrency==null?null:settlementCurrency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fx")
		public CommodityExercise.CommodityExerciseBuilder setFx(CommodityFx fx) {
			this.fx = fx==null?null:fx.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("conversionFactor")
		public CommodityExercise.CommodityExerciseBuilder setConversionFactor(BigDecimal conversionFactor) {
			this.conversionFactor = conversionFactor==null?null:conversionFactor;
			return this;
		}
		@Override
		@RosettaAttribute("commodityPaymentDatesModel")
		public CommodityExercise.CommodityExerciseBuilder setCommodityPaymentDatesModel(CommodityPaymentDatesModel commodityPaymentDatesModel) {
			this.commodityPaymentDatesModel = commodityPaymentDatesModel==null?null:commodityPaymentDatesModel.toBuilder();
			return this;
		}
		
		@Override
		public CommodityExercise build() {
			return new CommodityExercise.CommodityExerciseImpl(this);
		}
		
		@Override
		public CommodityExercise.CommodityExerciseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityExercise.CommodityExerciseBuilder prune() {
			if (americanExercise!=null && !americanExercise.prune().hasData()) americanExercise = null;
			if (europeanExercise!=null && !europeanExercise.prune().hasData()) europeanExercise = null;
			if (settlementCurrency!=null && !settlementCurrency.prune().hasData()) settlementCurrency = null;
			if (fx!=null && !fx.prune().hasData()) fx = null;
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
			if (getFx()!=null && getFx().hasData()) return true;
			if (getConversionFactor()!=null) return true;
			if (getCommodityPaymentDatesModel()!=null && getCommodityPaymentDatesModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityExercise.CommodityExerciseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityExercise.CommodityExerciseBuilder o = (CommodityExercise.CommodityExerciseBuilder) other;
			
			merger.mergeRosetta(getAmericanExercise(), o.getAmericanExercise(), this::setAmericanExercise);
			merger.mergeRosetta(getEuropeanExercise(), o.getEuropeanExercise(), this::setEuropeanExercise);
			merger.mergeRosetta(getSettlementCurrency(), o.getSettlementCurrency(), this::setSettlementCurrency);
			merger.mergeRosetta(getFx(), o.getFx(), this::setFx);
			merger.mergeRosetta(getCommodityPaymentDatesModel(), o.getCommodityPaymentDatesModel(), this::setCommodityPaymentDatesModel);
			
			merger.mergeBasic(getAutomaticExercise(), o.getAutomaticExercise(), this::setAutomaticExercise);
			merger.mergeBasic(getWrittenConfirmation(), o.getWrittenConfirmation(), this::setWrittenConfirmation);
			merger.mergeBasic(getConversionFactor(), o.getConversionFactor(), this::setConversionFactor);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityExercise _that = getType().cast(o);
		
			if (!Objects.equals(americanExercise, _that.getAmericanExercise())) return false;
			if (!Objects.equals(europeanExercise, _that.getEuropeanExercise())) return false;
			if (!Objects.equals(automaticExercise, _that.getAutomaticExercise())) return false;
			if (!Objects.equals(writtenConfirmation, _that.getWrittenConfirmation())) return false;
			if (!Objects.equals(settlementCurrency, _that.getSettlementCurrency())) return false;
			if (!Objects.equals(fx, _that.getFx())) return false;
			if (!Objects.equals(conversionFactor, _that.getConversionFactor())) return false;
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
			_result = 31 * _result + (fx != null ? fx.hashCode() : 0);
			_result = 31 * _result + (conversionFactor != null ? conversionFactor.hashCode() : 0);
			_result = 31 * _result + (commodityPaymentDatesModel != null ? commodityPaymentDatesModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityExerciseBuilder {" +
				"americanExercise=" + this.americanExercise + ", " +
				"europeanExercise=" + this.europeanExercise + ", " +
				"automaticExercise=" + this.automaticExercise + ", " +
				"writtenConfirmation=" + this.writtenConfirmation + ", " +
				"settlementCurrency=" + this.settlementCurrency + ", " +
				"fx=" + this.fx + ", " +
				"conversionFactor=" + this.conversionFactor + ", " +
				"commodityPaymentDatesModel=" + this.commodityPaymentDatesModel +
			'}';
		}
	}
}
