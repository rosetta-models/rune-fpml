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
import fpml.confirmation.Currency;
import fpml.confirmation.FxLinkedNotionalSchedule;
import fpml.confirmation.FxLinkedNotionalSchedule.FxLinkedNotionalScheduleBuilder;
import fpml.confirmation.FxLinkedNotionalSchedule.FxLinkedNotionalScheduleBuilderImpl;
import fpml.confirmation.FxLinkedNotionalSchedule.FxLinkedNotionalScheduleImpl;
import fpml.confirmation.FxSpotRateSource;
import fpml.confirmation.NotionalReference;
import fpml.confirmation.RelativeDateOffset;
import fpml.confirmation.meta.FxLinkedNotionalScheduleMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type to describe a notional schedule where each notional that applies to a calculation period is calculated with reference to a notional amount or notional amount schedule in a different currency by means of a spot currency exchange rate which is normally observed at the beginning of each period.
 * @version ${project.version}
 */
@RosettaDataType(value="FxLinkedNotionalSchedule", builder=FxLinkedNotionalSchedule.FxLinkedNotionalScheduleBuilderImpl.class, version="${project.version}")
public interface FxLinkedNotionalSchedule extends RosettaModelObject {

	FxLinkedNotionalScheduleMeta metaData = new FxLinkedNotionalScheduleMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A pointer style reference to the associated constant notional schedule defined elsewhere in the document which contains the currency amounts which will be converted into the varying notional currency amounts using the spot currency exchange rate.
	 */
	NotionalReference getConstantNotionalScheduleReference();
	/**
	 * The initial currency amount for the varying notional. This may be omitted for a forward starting swap if the FX-linked notional value is not known at deal inception.
	 */
	BigDecimal getInitialValue();
	/**
	 * The currency of the varying notional amount, i.e. the notional amount being determined periodically based on observation of a spot currency exchange rate.
	 */
	Currency getVaryingNotionalCurrency();
	/**
	 * The dates on which spot currency exchange rates are observed for purposes of determining the varying notional currency amount that will apply to a calculation period.
	 */
	RelativeDateOffset getVaryingNotionalFixingDates();
	/**
	 * The information source and time at which the spot currency exchange rate will be observed.
	 */
	FxSpotRateSource getFxSpotRateSource();
	/**
	 * The dates on which interim exchanges of notional are paid. Interim exchanges will arise as a result of changes in the spot currency exchange amount or changes in the constant notional schedule (e.g. amortization).
	 */
	RelativeDateOffset getVaryingNotionalInterimExchangePaymentDates();

	/*********************** Build Methods  ***********************/
	FxLinkedNotionalSchedule build();
	
	FxLinkedNotionalSchedule.FxLinkedNotionalScheduleBuilder toBuilder();
	
	static FxLinkedNotionalSchedule.FxLinkedNotionalScheduleBuilder builder() {
		return new FxLinkedNotionalSchedule.FxLinkedNotionalScheduleBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxLinkedNotionalSchedule> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxLinkedNotionalSchedule> getType() {
		return FxLinkedNotionalSchedule.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("constantNotionalScheduleReference"), processor, NotionalReference.class, getConstantNotionalScheduleReference());
		processor.processBasic(path.newSubPath("initialValue"), BigDecimal.class, getInitialValue(), this);
		processRosetta(path.newSubPath("varyingNotionalCurrency"), processor, Currency.class, getVaryingNotionalCurrency());
		processRosetta(path.newSubPath("varyingNotionalFixingDates"), processor, RelativeDateOffset.class, getVaryingNotionalFixingDates());
		processRosetta(path.newSubPath("fxSpotRateSource"), processor, FxSpotRateSource.class, getFxSpotRateSource());
		processRosetta(path.newSubPath("varyingNotionalInterimExchangePaymentDates"), processor, RelativeDateOffset.class, getVaryingNotionalInterimExchangePaymentDates());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxLinkedNotionalScheduleBuilder extends FxLinkedNotionalSchedule, RosettaModelObjectBuilder {
		NotionalReference.NotionalReferenceBuilder getOrCreateConstantNotionalScheduleReference();
		NotionalReference.NotionalReferenceBuilder getConstantNotionalScheduleReference();
		Currency.CurrencyBuilder getOrCreateVaryingNotionalCurrency();
		Currency.CurrencyBuilder getVaryingNotionalCurrency();
		RelativeDateOffset.RelativeDateOffsetBuilder getOrCreateVaryingNotionalFixingDates();
		RelativeDateOffset.RelativeDateOffsetBuilder getVaryingNotionalFixingDates();
		FxSpotRateSource.FxSpotRateSourceBuilder getOrCreateFxSpotRateSource();
		FxSpotRateSource.FxSpotRateSourceBuilder getFxSpotRateSource();
		RelativeDateOffset.RelativeDateOffsetBuilder getOrCreateVaryingNotionalInterimExchangePaymentDates();
		RelativeDateOffset.RelativeDateOffsetBuilder getVaryingNotionalInterimExchangePaymentDates();
		FxLinkedNotionalSchedule.FxLinkedNotionalScheduleBuilder setConstantNotionalScheduleReference(NotionalReference constantNotionalScheduleReference);
		FxLinkedNotionalSchedule.FxLinkedNotionalScheduleBuilder setInitialValue(BigDecimal initialValue);
		FxLinkedNotionalSchedule.FxLinkedNotionalScheduleBuilder setVaryingNotionalCurrency(Currency varyingNotionalCurrency);
		FxLinkedNotionalSchedule.FxLinkedNotionalScheduleBuilder setVaryingNotionalFixingDates(RelativeDateOffset varyingNotionalFixingDates);
		FxLinkedNotionalSchedule.FxLinkedNotionalScheduleBuilder setFxSpotRateSource(FxSpotRateSource fxSpotRateSource);
		FxLinkedNotionalSchedule.FxLinkedNotionalScheduleBuilder setVaryingNotionalInterimExchangePaymentDates(RelativeDateOffset varyingNotionalInterimExchangePaymentDates);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("constantNotionalScheduleReference"), processor, NotionalReference.NotionalReferenceBuilder.class, getConstantNotionalScheduleReference());
			processor.processBasic(path.newSubPath("initialValue"), BigDecimal.class, getInitialValue(), this);
			processRosetta(path.newSubPath("varyingNotionalCurrency"), processor, Currency.CurrencyBuilder.class, getVaryingNotionalCurrency());
			processRosetta(path.newSubPath("varyingNotionalFixingDates"), processor, RelativeDateOffset.RelativeDateOffsetBuilder.class, getVaryingNotionalFixingDates());
			processRosetta(path.newSubPath("fxSpotRateSource"), processor, FxSpotRateSource.FxSpotRateSourceBuilder.class, getFxSpotRateSource());
			processRosetta(path.newSubPath("varyingNotionalInterimExchangePaymentDates"), processor, RelativeDateOffset.RelativeDateOffsetBuilder.class, getVaryingNotionalInterimExchangePaymentDates());
		}
		

		FxLinkedNotionalSchedule.FxLinkedNotionalScheduleBuilder prune();
	}

	/*********************** Immutable Implementation of FxLinkedNotionalSchedule  ***********************/
	class FxLinkedNotionalScheduleImpl implements FxLinkedNotionalSchedule {
		private final NotionalReference constantNotionalScheduleReference;
		private final BigDecimal initialValue;
		private final Currency varyingNotionalCurrency;
		private final RelativeDateOffset varyingNotionalFixingDates;
		private final FxSpotRateSource fxSpotRateSource;
		private final RelativeDateOffset varyingNotionalInterimExchangePaymentDates;
		
		protected FxLinkedNotionalScheduleImpl(FxLinkedNotionalSchedule.FxLinkedNotionalScheduleBuilder builder) {
			this.constantNotionalScheduleReference = ofNullable(builder.getConstantNotionalScheduleReference()).map(f->f.build()).orElse(null);
			this.initialValue = builder.getInitialValue();
			this.varyingNotionalCurrency = ofNullable(builder.getVaryingNotionalCurrency()).map(f->f.build()).orElse(null);
			this.varyingNotionalFixingDates = ofNullable(builder.getVaryingNotionalFixingDates()).map(f->f.build()).orElse(null);
			this.fxSpotRateSource = ofNullable(builder.getFxSpotRateSource()).map(f->f.build()).orElse(null);
			this.varyingNotionalInterimExchangePaymentDates = ofNullable(builder.getVaryingNotionalInterimExchangePaymentDates()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("constantNotionalScheduleReference")
		public NotionalReference getConstantNotionalScheduleReference() {
			return constantNotionalScheduleReference;
		}
		
		@Override
		@RosettaAttribute("initialValue")
		public BigDecimal getInitialValue() {
			return initialValue;
		}
		
		@Override
		@RosettaAttribute("varyingNotionalCurrency")
		public Currency getVaryingNotionalCurrency() {
			return varyingNotionalCurrency;
		}
		
		@Override
		@RosettaAttribute("varyingNotionalFixingDates")
		public RelativeDateOffset getVaryingNotionalFixingDates() {
			return varyingNotionalFixingDates;
		}
		
		@Override
		@RosettaAttribute("fxSpotRateSource")
		public FxSpotRateSource getFxSpotRateSource() {
			return fxSpotRateSource;
		}
		
		@Override
		@RosettaAttribute("varyingNotionalInterimExchangePaymentDates")
		public RelativeDateOffset getVaryingNotionalInterimExchangePaymentDates() {
			return varyingNotionalInterimExchangePaymentDates;
		}
		
		@Override
		public FxLinkedNotionalSchedule build() {
			return this;
		}
		
		@Override
		public FxLinkedNotionalSchedule.FxLinkedNotionalScheduleBuilder toBuilder() {
			FxLinkedNotionalSchedule.FxLinkedNotionalScheduleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxLinkedNotionalSchedule.FxLinkedNotionalScheduleBuilder builder) {
			ofNullable(getConstantNotionalScheduleReference()).ifPresent(builder::setConstantNotionalScheduleReference);
			ofNullable(getInitialValue()).ifPresent(builder::setInitialValue);
			ofNullable(getVaryingNotionalCurrency()).ifPresent(builder::setVaryingNotionalCurrency);
			ofNullable(getVaryingNotionalFixingDates()).ifPresent(builder::setVaryingNotionalFixingDates);
			ofNullable(getFxSpotRateSource()).ifPresent(builder::setFxSpotRateSource);
			ofNullable(getVaryingNotionalInterimExchangePaymentDates()).ifPresent(builder::setVaryingNotionalInterimExchangePaymentDates);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxLinkedNotionalSchedule _that = getType().cast(o);
		
			if (!Objects.equals(constantNotionalScheduleReference, _that.getConstantNotionalScheduleReference())) return false;
			if (!Objects.equals(initialValue, _that.getInitialValue())) return false;
			if (!Objects.equals(varyingNotionalCurrency, _that.getVaryingNotionalCurrency())) return false;
			if (!Objects.equals(varyingNotionalFixingDates, _that.getVaryingNotionalFixingDates())) return false;
			if (!Objects.equals(fxSpotRateSource, _that.getFxSpotRateSource())) return false;
			if (!Objects.equals(varyingNotionalInterimExchangePaymentDates, _that.getVaryingNotionalInterimExchangePaymentDates())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (constantNotionalScheduleReference != null ? constantNotionalScheduleReference.hashCode() : 0);
			_result = 31 * _result + (initialValue != null ? initialValue.hashCode() : 0);
			_result = 31 * _result + (varyingNotionalCurrency != null ? varyingNotionalCurrency.hashCode() : 0);
			_result = 31 * _result + (varyingNotionalFixingDates != null ? varyingNotionalFixingDates.hashCode() : 0);
			_result = 31 * _result + (fxSpotRateSource != null ? fxSpotRateSource.hashCode() : 0);
			_result = 31 * _result + (varyingNotionalInterimExchangePaymentDates != null ? varyingNotionalInterimExchangePaymentDates.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxLinkedNotionalSchedule {" +
				"constantNotionalScheduleReference=" + this.constantNotionalScheduleReference + ", " +
				"initialValue=" + this.initialValue + ", " +
				"varyingNotionalCurrency=" + this.varyingNotionalCurrency + ", " +
				"varyingNotionalFixingDates=" + this.varyingNotionalFixingDates + ", " +
				"fxSpotRateSource=" + this.fxSpotRateSource + ", " +
				"varyingNotionalInterimExchangePaymentDates=" + this.varyingNotionalInterimExchangePaymentDates +
			'}';
		}
	}

	/*********************** Builder Implementation of FxLinkedNotionalSchedule  ***********************/
	class FxLinkedNotionalScheduleBuilderImpl implements FxLinkedNotionalSchedule.FxLinkedNotionalScheduleBuilder {
	
		protected NotionalReference.NotionalReferenceBuilder constantNotionalScheduleReference;
		protected BigDecimal initialValue;
		protected Currency.CurrencyBuilder varyingNotionalCurrency;
		protected RelativeDateOffset.RelativeDateOffsetBuilder varyingNotionalFixingDates;
		protected FxSpotRateSource.FxSpotRateSourceBuilder fxSpotRateSource;
		protected RelativeDateOffset.RelativeDateOffsetBuilder varyingNotionalInterimExchangePaymentDates;
	
		public FxLinkedNotionalScheduleBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("constantNotionalScheduleReference")
		public NotionalReference.NotionalReferenceBuilder getConstantNotionalScheduleReference() {
			return constantNotionalScheduleReference;
		}
		
		@Override
		public NotionalReference.NotionalReferenceBuilder getOrCreateConstantNotionalScheduleReference() {
			NotionalReference.NotionalReferenceBuilder result;
			if (constantNotionalScheduleReference!=null) {
				result = constantNotionalScheduleReference;
			}
			else {
				result = constantNotionalScheduleReference = NotionalReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("initialValue")
		public BigDecimal getInitialValue() {
			return initialValue;
		}
		
		@Override
		@RosettaAttribute("varyingNotionalCurrency")
		public Currency.CurrencyBuilder getVaryingNotionalCurrency() {
			return varyingNotionalCurrency;
		}
		
		@Override
		public Currency.CurrencyBuilder getOrCreateVaryingNotionalCurrency() {
			Currency.CurrencyBuilder result;
			if (varyingNotionalCurrency!=null) {
				result = varyingNotionalCurrency;
			}
			else {
				result = varyingNotionalCurrency = Currency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("varyingNotionalFixingDates")
		public RelativeDateOffset.RelativeDateOffsetBuilder getVaryingNotionalFixingDates() {
			return varyingNotionalFixingDates;
		}
		
		@Override
		public RelativeDateOffset.RelativeDateOffsetBuilder getOrCreateVaryingNotionalFixingDates() {
			RelativeDateOffset.RelativeDateOffsetBuilder result;
			if (varyingNotionalFixingDates!=null) {
				result = varyingNotionalFixingDates;
			}
			else {
				result = varyingNotionalFixingDates = RelativeDateOffset.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fxSpotRateSource")
		public FxSpotRateSource.FxSpotRateSourceBuilder getFxSpotRateSource() {
			return fxSpotRateSource;
		}
		
		@Override
		public FxSpotRateSource.FxSpotRateSourceBuilder getOrCreateFxSpotRateSource() {
			FxSpotRateSource.FxSpotRateSourceBuilder result;
			if (fxSpotRateSource!=null) {
				result = fxSpotRateSource;
			}
			else {
				result = fxSpotRateSource = FxSpotRateSource.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("varyingNotionalInterimExchangePaymentDates")
		public RelativeDateOffset.RelativeDateOffsetBuilder getVaryingNotionalInterimExchangePaymentDates() {
			return varyingNotionalInterimExchangePaymentDates;
		}
		
		@Override
		public RelativeDateOffset.RelativeDateOffsetBuilder getOrCreateVaryingNotionalInterimExchangePaymentDates() {
			RelativeDateOffset.RelativeDateOffsetBuilder result;
			if (varyingNotionalInterimExchangePaymentDates!=null) {
				result = varyingNotionalInterimExchangePaymentDates;
			}
			else {
				result = varyingNotionalInterimExchangePaymentDates = RelativeDateOffset.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("constantNotionalScheduleReference")
		public FxLinkedNotionalSchedule.FxLinkedNotionalScheduleBuilder setConstantNotionalScheduleReference(NotionalReference constantNotionalScheduleReference) {
			this.constantNotionalScheduleReference = constantNotionalScheduleReference==null?null:constantNotionalScheduleReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("initialValue")
		public FxLinkedNotionalSchedule.FxLinkedNotionalScheduleBuilder setInitialValue(BigDecimal initialValue) {
			this.initialValue = initialValue==null?null:initialValue;
			return this;
		}
		@Override
		@RosettaAttribute("varyingNotionalCurrency")
		public FxLinkedNotionalSchedule.FxLinkedNotionalScheduleBuilder setVaryingNotionalCurrency(Currency varyingNotionalCurrency) {
			this.varyingNotionalCurrency = varyingNotionalCurrency==null?null:varyingNotionalCurrency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("varyingNotionalFixingDates")
		public FxLinkedNotionalSchedule.FxLinkedNotionalScheduleBuilder setVaryingNotionalFixingDates(RelativeDateOffset varyingNotionalFixingDates) {
			this.varyingNotionalFixingDates = varyingNotionalFixingDates==null?null:varyingNotionalFixingDates.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fxSpotRateSource")
		public FxLinkedNotionalSchedule.FxLinkedNotionalScheduleBuilder setFxSpotRateSource(FxSpotRateSource fxSpotRateSource) {
			this.fxSpotRateSource = fxSpotRateSource==null?null:fxSpotRateSource.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("varyingNotionalInterimExchangePaymentDates")
		public FxLinkedNotionalSchedule.FxLinkedNotionalScheduleBuilder setVaryingNotionalInterimExchangePaymentDates(RelativeDateOffset varyingNotionalInterimExchangePaymentDates) {
			this.varyingNotionalInterimExchangePaymentDates = varyingNotionalInterimExchangePaymentDates==null?null:varyingNotionalInterimExchangePaymentDates.toBuilder();
			return this;
		}
		
		@Override
		public FxLinkedNotionalSchedule build() {
			return new FxLinkedNotionalSchedule.FxLinkedNotionalScheduleImpl(this);
		}
		
		@Override
		public FxLinkedNotionalSchedule.FxLinkedNotionalScheduleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxLinkedNotionalSchedule.FxLinkedNotionalScheduleBuilder prune() {
			if (constantNotionalScheduleReference!=null && !constantNotionalScheduleReference.prune().hasData()) constantNotionalScheduleReference = null;
			if (varyingNotionalCurrency!=null && !varyingNotionalCurrency.prune().hasData()) varyingNotionalCurrency = null;
			if (varyingNotionalFixingDates!=null && !varyingNotionalFixingDates.prune().hasData()) varyingNotionalFixingDates = null;
			if (fxSpotRateSource!=null && !fxSpotRateSource.prune().hasData()) fxSpotRateSource = null;
			if (varyingNotionalInterimExchangePaymentDates!=null && !varyingNotionalInterimExchangePaymentDates.prune().hasData()) varyingNotionalInterimExchangePaymentDates = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getConstantNotionalScheduleReference()!=null && getConstantNotionalScheduleReference().hasData()) return true;
			if (getInitialValue()!=null) return true;
			if (getVaryingNotionalCurrency()!=null && getVaryingNotionalCurrency().hasData()) return true;
			if (getVaryingNotionalFixingDates()!=null && getVaryingNotionalFixingDates().hasData()) return true;
			if (getFxSpotRateSource()!=null && getFxSpotRateSource().hasData()) return true;
			if (getVaryingNotionalInterimExchangePaymentDates()!=null && getVaryingNotionalInterimExchangePaymentDates().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxLinkedNotionalSchedule.FxLinkedNotionalScheduleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxLinkedNotionalSchedule.FxLinkedNotionalScheduleBuilder o = (FxLinkedNotionalSchedule.FxLinkedNotionalScheduleBuilder) other;
			
			merger.mergeRosetta(getConstantNotionalScheduleReference(), o.getConstantNotionalScheduleReference(), this::setConstantNotionalScheduleReference);
			merger.mergeRosetta(getVaryingNotionalCurrency(), o.getVaryingNotionalCurrency(), this::setVaryingNotionalCurrency);
			merger.mergeRosetta(getVaryingNotionalFixingDates(), o.getVaryingNotionalFixingDates(), this::setVaryingNotionalFixingDates);
			merger.mergeRosetta(getFxSpotRateSource(), o.getFxSpotRateSource(), this::setFxSpotRateSource);
			merger.mergeRosetta(getVaryingNotionalInterimExchangePaymentDates(), o.getVaryingNotionalInterimExchangePaymentDates(), this::setVaryingNotionalInterimExchangePaymentDates);
			
			merger.mergeBasic(getInitialValue(), o.getInitialValue(), this::setInitialValue);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxLinkedNotionalSchedule _that = getType().cast(o);
		
			if (!Objects.equals(constantNotionalScheduleReference, _that.getConstantNotionalScheduleReference())) return false;
			if (!Objects.equals(initialValue, _that.getInitialValue())) return false;
			if (!Objects.equals(varyingNotionalCurrency, _that.getVaryingNotionalCurrency())) return false;
			if (!Objects.equals(varyingNotionalFixingDates, _that.getVaryingNotionalFixingDates())) return false;
			if (!Objects.equals(fxSpotRateSource, _that.getFxSpotRateSource())) return false;
			if (!Objects.equals(varyingNotionalInterimExchangePaymentDates, _that.getVaryingNotionalInterimExchangePaymentDates())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (constantNotionalScheduleReference != null ? constantNotionalScheduleReference.hashCode() : 0);
			_result = 31 * _result + (initialValue != null ? initialValue.hashCode() : 0);
			_result = 31 * _result + (varyingNotionalCurrency != null ? varyingNotionalCurrency.hashCode() : 0);
			_result = 31 * _result + (varyingNotionalFixingDates != null ? varyingNotionalFixingDates.hashCode() : 0);
			_result = 31 * _result + (fxSpotRateSource != null ? fxSpotRateSource.hashCode() : 0);
			_result = 31 * _result + (varyingNotionalInterimExchangePaymentDates != null ? varyingNotionalInterimExchangePaymentDates.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxLinkedNotionalScheduleBuilder {" +
				"constantNotionalScheduleReference=" + this.constantNotionalScheduleReference + ", " +
				"initialValue=" + this.initialValue + ", " +
				"varyingNotionalCurrency=" + this.varyingNotionalCurrency + ", " +
				"varyingNotionalFixingDates=" + this.varyingNotionalFixingDates + ", " +
				"fxSpotRateSource=" + this.fxSpotRateSource + ", " +
				"varyingNotionalInterimExchangePaymentDates=" + this.varyingNotionalInterimExchangePaymentDates +
			'}';
		}
	}
}
