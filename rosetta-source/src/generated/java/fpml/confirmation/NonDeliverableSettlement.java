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
import fpml.confirmation.AdjustableDates;
import fpml.confirmation.Currency;
import fpml.confirmation.FxFixingDate;
import fpml.confirmation.NonDeliverableSettlement;
import fpml.confirmation.NonDeliverableSettlement.NonDeliverableSettlementBuilder;
import fpml.confirmation.NonDeliverableSettlement.NonDeliverableSettlementBuilderImpl;
import fpml.confirmation.NonDeliverableSettlement.NonDeliverableSettlementImpl;
import fpml.confirmation.PriceSourceDisruptionType;
import fpml.confirmation.SettlementRateOption;
import fpml.confirmation.meta.NonDeliverableSettlementMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type defining the parameters used when the reference currency of the swapStream is non-deliverable.
 * @version ${project.version}
 */
@RosettaDataType(value="NonDeliverableSettlement", builder=NonDeliverableSettlement.NonDeliverableSettlementBuilderImpl.class, version="${project.version}")
public interface NonDeliverableSettlement extends RosettaModelObject {

	NonDeliverableSettlementMeta metaData = new NonDeliverableSettlementMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The currency in which the swap stream is denominated.
	 */
	Currency getReferenceCurrency();
	/**
	 * The date, when expressed as a relative date, on which the currency rate will be determined for the purpose of specifying the amount in deliverable currency.
	 */
	FxFixingDate getFxFixingDate();
	/**
	 * The date, when expressed as a schedule of date(s), on which the currency rate will be determined for the purpose of specifying the amount in deliverable currency.
	 */
	AdjustableDates getFxFixingSchedule();
	/**
	 * The rate source for the conversion to the settlement currency. This source is specified through a scheme that reflects the terms of the Annex A to the 1998 FX and Currency Option Definitions.
	 */
	SettlementRateOption getSettlementRateOption();
	/**
	 * A type defining the parameters to get a new quote when a settlement rate option is disrupted.
	 */
	PriceSourceDisruptionType getPriceSourceDisruption();

	/*********************** Build Methods  ***********************/
	NonDeliverableSettlement build();
	
	NonDeliverableSettlement.NonDeliverableSettlementBuilder toBuilder();
	
	static NonDeliverableSettlement.NonDeliverableSettlementBuilder builder() {
		return new NonDeliverableSettlement.NonDeliverableSettlementBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends NonDeliverableSettlement> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends NonDeliverableSettlement> getType() {
		return NonDeliverableSettlement.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("referenceCurrency"), processor, Currency.class, getReferenceCurrency());
		processRosetta(path.newSubPath("fxFixingDate"), processor, FxFixingDate.class, getFxFixingDate());
		processRosetta(path.newSubPath("fxFixingSchedule"), processor, AdjustableDates.class, getFxFixingSchedule());
		processRosetta(path.newSubPath("settlementRateOption"), processor, SettlementRateOption.class, getSettlementRateOption());
		processRosetta(path.newSubPath("priceSourceDisruption"), processor, PriceSourceDisruptionType.class, getPriceSourceDisruption());
	}
	

	/*********************** Builder Interface  ***********************/
	interface NonDeliverableSettlementBuilder extends NonDeliverableSettlement, RosettaModelObjectBuilder {
		Currency.CurrencyBuilder getOrCreateReferenceCurrency();
		Currency.CurrencyBuilder getReferenceCurrency();
		FxFixingDate.FxFixingDateBuilder getOrCreateFxFixingDate();
		FxFixingDate.FxFixingDateBuilder getFxFixingDate();
		AdjustableDates.AdjustableDatesBuilder getOrCreateFxFixingSchedule();
		AdjustableDates.AdjustableDatesBuilder getFxFixingSchedule();
		SettlementRateOption.SettlementRateOptionBuilder getOrCreateSettlementRateOption();
		SettlementRateOption.SettlementRateOptionBuilder getSettlementRateOption();
		PriceSourceDisruptionType.PriceSourceDisruptionTypeBuilder getOrCreatePriceSourceDisruption();
		PriceSourceDisruptionType.PriceSourceDisruptionTypeBuilder getPriceSourceDisruption();
		NonDeliverableSettlement.NonDeliverableSettlementBuilder setReferenceCurrency(Currency referenceCurrency);
		NonDeliverableSettlement.NonDeliverableSettlementBuilder setFxFixingDate(FxFixingDate fxFixingDate);
		NonDeliverableSettlement.NonDeliverableSettlementBuilder setFxFixingSchedule(AdjustableDates fxFixingSchedule);
		NonDeliverableSettlement.NonDeliverableSettlementBuilder setSettlementRateOption(SettlementRateOption settlementRateOption);
		NonDeliverableSettlement.NonDeliverableSettlementBuilder setPriceSourceDisruption(PriceSourceDisruptionType priceSourceDisruption);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("referenceCurrency"), processor, Currency.CurrencyBuilder.class, getReferenceCurrency());
			processRosetta(path.newSubPath("fxFixingDate"), processor, FxFixingDate.FxFixingDateBuilder.class, getFxFixingDate());
			processRosetta(path.newSubPath("fxFixingSchedule"), processor, AdjustableDates.AdjustableDatesBuilder.class, getFxFixingSchedule());
			processRosetta(path.newSubPath("settlementRateOption"), processor, SettlementRateOption.SettlementRateOptionBuilder.class, getSettlementRateOption());
			processRosetta(path.newSubPath("priceSourceDisruption"), processor, PriceSourceDisruptionType.PriceSourceDisruptionTypeBuilder.class, getPriceSourceDisruption());
		}
		

		NonDeliverableSettlement.NonDeliverableSettlementBuilder prune();
	}

	/*********************** Immutable Implementation of NonDeliverableSettlement  ***********************/
	class NonDeliverableSettlementImpl implements NonDeliverableSettlement {
		private final Currency referenceCurrency;
		private final FxFixingDate fxFixingDate;
		private final AdjustableDates fxFixingSchedule;
		private final SettlementRateOption settlementRateOption;
		private final PriceSourceDisruptionType priceSourceDisruption;
		
		protected NonDeliverableSettlementImpl(NonDeliverableSettlement.NonDeliverableSettlementBuilder builder) {
			this.referenceCurrency = ofNullable(builder.getReferenceCurrency()).map(f->f.build()).orElse(null);
			this.fxFixingDate = ofNullable(builder.getFxFixingDate()).map(f->f.build()).orElse(null);
			this.fxFixingSchedule = ofNullable(builder.getFxFixingSchedule()).map(f->f.build()).orElse(null);
			this.settlementRateOption = ofNullable(builder.getSettlementRateOption()).map(f->f.build()).orElse(null);
			this.priceSourceDisruption = ofNullable(builder.getPriceSourceDisruption()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("referenceCurrency")
		public Currency getReferenceCurrency() {
			return referenceCurrency;
		}
		
		@Override
		@RosettaAttribute("fxFixingDate")
		public FxFixingDate getFxFixingDate() {
			return fxFixingDate;
		}
		
		@Override
		@RosettaAttribute("fxFixingSchedule")
		public AdjustableDates getFxFixingSchedule() {
			return fxFixingSchedule;
		}
		
		@Override
		@RosettaAttribute("settlementRateOption")
		public SettlementRateOption getSettlementRateOption() {
			return settlementRateOption;
		}
		
		@Override
		@RosettaAttribute("priceSourceDisruption")
		public PriceSourceDisruptionType getPriceSourceDisruption() {
			return priceSourceDisruption;
		}
		
		@Override
		public NonDeliverableSettlement build() {
			return this;
		}
		
		@Override
		public NonDeliverableSettlement.NonDeliverableSettlementBuilder toBuilder() {
			NonDeliverableSettlement.NonDeliverableSettlementBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NonDeliverableSettlement.NonDeliverableSettlementBuilder builder) {
			ofNullable(getReferenceCurrency()).ifPresent(builder::setReferenceCurrency);
			ofNullable(getFxFixingDate()).ifPresent(builder::setFxFixingDate);
			ofNullable(getFxFixingSchedule()).ifPresent(builder::setFxFixingSchedule);
			ofNullable(getSettlementRateOption()).ifPresent(builder::setSettlementRateOption);
			ofNullable(getPriceSourceDisruption()).ifPresent(builder::setPriceSourceDisruption);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NonDeliverableSettlement _that = getType().cast(o);
		
			if (!Objects.equals(referenceCurrency, _that.getReferenceCurrency())) return false;
			if (!Objects.equals(fxFixingDate, _that.getFxFixingDate())) return false;
			if (!Objects.equals(fxFixingSchedule, _that.getFxFixingSchedule())) return false;
			if (!Objects.equals(settlementRateOption, _that.getSettlementRateOption())) return false;
			if (!Objects.equals(priceSourceDisruption, _that.getPriceSourceDisruption())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (referenceCurrency != null ? referenceCurrency.hashCode() : 0);
			_result = 31 * _result + (fxFixingDate != null ? fxFixingDate.hashCode() : 0);
			_result = 31 * _result + (fxFixingSchedule != null ? fxFixingSchedule.hashCode() : 0);
			_result = 31 * _result + (settlementRateOption != null ? settlementRateOption.hashCode() : 0);
			_result = 31 * _result + (priceSourceDisruption != null ? priceSourceDisruption.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NonDeliverableSettlement {" +
				"referenceCurrency=" + this.referenceCurrency + ", " +
				"fxFixingDate=" + this.fxFixingDate + ", " +
				"fxFixingSchedule=" + this.fxFixingSchedule + ", " +
				"settlementRateOption=" + this.settlementRateOption + ", " +
				"priceSourceDisruption=" + this.priceSourceDisruption +
			'}';
		}
	}

	/*********************** Builder Implementation of NonDeliverableSettlement  ***********************/
	class NonDeliverableSettlementBuilderImpl implements NonDeliverableSettlement.NonDeliverableSettlementBuilder {
	
		protected Currency.CurrencyBuilder referenceCurrency;
		protected FxFixingDate.FxFixingDateBuilder fxFixingDate;
		protected AdjustableDates.AdjustableDatesBuilder fxFixingSchedule;
		protected SettlementRateOption.SettlementRateOptionBuilder settlementRateOption;
		protected PriceSourceDisruptionType.PriceSourceDisruptionTypeBuilder priceSourceDisruption;
	
		public NonDeliverableSettlementBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("referenceCurrency")
		public Currency.CurrencyBuilder getReferenceCurrency() {
			return referenceCurrency;
		}
		
		@Override
		public Currency.CurrencyBuilder getOrCreateReferenceCurrency() {
			Currency.CurrencyBuilder result;
			if (referenceCurrency!=null) {
				result = referenceCurrency;
			}
			else {
				result = referenceCurrency = Currency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fxFixingDate")
		public FxFixingDate.FxFixingDateBuilder getFxFixingDate() {
			return fxFixingDate;
		}
		
		@Override
		public FxFixingDate.FxFixingDateBuilder getOrCreateFxFixingDate() {
			FxFixingDate.FxFixingDateBuilder result;
			if (fxFixingDate!=null) {
				result = fxFixingDate;
			}
			else {
				result = fxFixingDate = FxFixingDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fxFixingSchedule")
		public AdjustableDates.AdjustableDatesBuilder getFxFixingSchedule() {
			return fxFixingSchedule;
		}
		
		@Override
		public AdjustableDates.AdjustableDatesBuilder getOrCreateFxFixingSchedule() {
			AdjustableDates.AdjustableDatesBuilder result;
			if (fxFixingSchedule!=null) {
				result = fxFixingSchedule;
			}
			else {
				result = fxFixingSchedule = AdjustableDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("settlementRateOption")
		public SettlementRateOption.SettlementRateOptionBuilder getSettlementRateOption() {
			return settlementRateOption;
		}
		
		@Override
		public SettlementRateOption.SettlementRateOptionBuilder getOrCreateSettlementRateOption() {
			SettlementRateOption.SettlementRateOptionBuilder result;
			if (settlementRateOption!=null) {
				result = settlementRateOption;
			}
			else {
				result = settlementRateOption = SettlementRateOption.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("priceSourceDisruption")
		public PriceSourceDisruptionType.PriceSourceDisruptionTypeBuilder getPriceSourceDisruption() {
			return priceSourceDisruption;
		}
		
		@Override
		public PriceSourceDisruptionType.PriceSourceDisruptionTypeBuilder getOrCreatePriceSourceDisruption() {
			PriceSourceDisruptionType.PriceSourceDisruptionTypeBuilder result;
			if (priceSourceDisruption!=null) {
				result = priceSourceDisruption;
			}
			else {
				result = priceSourceDisruption = PriceSourceDisruptionType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("referenceCurrency")
		public NonDeliverableSettlement.NonDeliverableSettlementBuilder setReferenceCurrency(Currency referenceCurrency) {
			this.referenceCurrency = referenceCurrency==null?null:referenceCurrency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fxFixingDate")
		public NonDeliverableSettlement.NonDeliverableSettlementBuilder setFxFixingDate(FxFixingDate fxFixingDate) {
			this.fxFixingDate = fxFixingDate==null?null:fxFixingDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fxFixingSchedule")
		public NonDeliverableSettlement.NonDeliverableSettlementBuilder setFxFixingSchedule(AdjustableDates fxFixingSchedule) {
			this.fxFixingSchedule = fxFixingSchedule==null?null:fxFixingSchedule.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("settlementRateOption")
		public NonDeliverableSettlement.NonDeliverableSettlementBuilder setSettlementRateOption(SettlementRateOption settlementRateOption) {
			this.settlementRateOption = settlementRateOption==null?null:settlementRateOption.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("priceSourceDisruption")
		public NonDeliverableSettlement.NonDeliverableSettlementBuilder setPriceSourceDisruption(PriceSourceDisruptionType priceSourceDisruption) {
			this.priceSourceDisruption = priceSourceDisruption==null?null:priceSourceDisruption.toBuilder();
			return this;
		}
		
		@Override
		public NonDeliverableSettlement build() {
			return new NonDeliverableSettlement.NonDeliverableSettlementImpl(this);
		}
		
		@Override
		public NonDeliverableSettlement.NonDeliverableSettlementBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NonDeliverableSettlement.NonDeliverableSettlementBuilder prune() {
			if (referenceCurrency!=null && !referenceCurrency.prune().hasData()) referenceCurrency = null;
			if (fxFixingDate!=null && !fxFixingDate.prune().hasData()) fxFixingDate = null;
			if (fxFixingSchedule!=null && !fxFixingSchedule.prune().hasData()) fxFixingSchedule = null;
			if (settlementRateOption!=null && !settlementRateOption.prune().hasData()) settlementRateOption = null;
			if (priceSourceDisruption!=null && !priceSourceDisruption.prune().hasData()) priceSourceDisruption = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getReferenceCurrency()!=null && getReferenceCurrency().hasData()) return true;
			if (getFxFixingDate()!=null && getFxFixingDate().hasData()) return true;
			if (getFxFixingSchedule()!=null && getFxFixingSchedule().hasData()) return true;
			if (getSettlementRateOption()!=null && getSettlementRateOption().hasData()) return true;
			if (getPriceSourceDisruption()!=null && getPriceSourceDisruption().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NonDeliverableSettlement.NonDeliverableSettlementBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			NonDeliverableSettlement.NonDeliverableSettlementBuilder o = (NonDeliverableSettlement.NonDeliverableSettlementBuilder) other;
			
			merger.mergeRosetta(getReferenceCurrency(), o.getReferenceCurrency(), this::setReferenceCurrency);
			merger.mergeRosetta(getFxFixingDate(), o.getFxFixingDate(), this::setFxFixingDate);
			merger.mergeRosetta(getFxFixingSchedule(), o.getFxFixingSchedule(), this::setFxFixingSchedule);
			merger.mergeRosetta(getSettlementRateOption(), o.getSettlementRateOption(), this::setSettlementRateOption);
			merger.mergeRosetta(getPriceSourceDisruption(), o.getPriceSourceDisruption(), this::setPriceSourceDisruption);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NonDeliverableSettlement _that = getType().cast(o);
		
			if (!Objects.equals(referenceCurrency, _that.getReferenceCurrency())) return false;
			if (!Objects.equals(fxFixingDate, _that.getFxFixingDate())) return false;
			if (!Objects.equals(fxFixingSchedule, _that.getFxFixingSchedule())) return false;
			if (!Objects.equals(settlementRateOption, _that.getSettlementRateOption())) return false;
			if (!Objects.equals(priceSourceDisruption, _that.getPriceSourceDisruption())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (referenceCurrency != null ? referenceCurrency.hashCode() : 0);
			_result = 31 * _result + (fxFixingDate != null ? fxFixingDate.hashCode() : 0);
			_result = 31 * _result + (fxFixingSchedule != null ? fxFixingSchedule.hashCode() : 0);
			_result = 31 * _result + (settlementRateOption != null ? settlementRateOption.hashCode() : 0);
			_result = 31 * _result + (priceSourceDisruption != null ? priceSourceDisruption.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NonDeliverableSettlementBuilder {" +
				"referenceCurrency=" + this.referenceCurrency + ", " +
				"fxFixingDate=" + this.fxFixingDate + ", " +
				"fxFixingSchedule=" + this.fxFixingSchedule + ", " +
				"settlementRateOption=" + this.settlementRateOption + ", " +
				"priceSourceDisruption=" + this.priceSourceDisruption +
			'}';
		}
	}
}
