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
import fpml.confirmation.ClearanceSystem;
import fpml.confirmation.DayCountFraction;
import fpml.confirmation.ExchangeId;
import fpml.confirmation.FloatingRateIndex;
import fpml.confirmation.IdentifiedCurrency;
import fpml.confirmation.InstrumentId;
import fpml.confirmation.Period;
import fpml.confirmation.ProductReference;
import fpml.confirmation.RateIndex;
import fpml.confirmation.RateIndex.RateIndexBuilder;
import fpml.confirmation.RateIndex.RateIndexBuilderImpl;
import fpml.confirmation.RateIndex.RateIndexImpl;
import fpml.confirmation.UnderlyingAssetType;
import fpml.confirmation.UnderlyingAssetType.UnderlyingAssetTypeBuilder;
import fpml.confirmation.UnderlyingAssetType.UnderlyingAssetTypeBuilderImpl;
import fpml.confirmation.UnderlyingAssetType.UnderlyingAssetTypeImpl;
import fpml.confirmation.meta.RateIndexMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Identifies a simple underlying asset that is an interest rate index. Used for specifying benchmark assets in the market environment in the pricing and risk model.
 * @version ${project.version}
 */
@RosettaDataType(value="RateIndex", builder=RateIndex.RateIndexBuilderImpl.class, version="${project.version}")
public interface RateIndex extends UnderlyingAssetType {

	RateIndexMeta metaData = new RateIndexMeta();

	/*********************** Getter Methods  ***********************/
	FloatingRateIndex getFloatingRateIndex();
	/**
	 * Specifies the term of the simple swap, e.g. 5Y.
	 */
	Period getTerm();
	/**
	 * Specifies the frequency at which the index pays, e.g. 6M.
	 */
	Period getPaymentFrequency();
	/**
	 * The day count basis for the index.
	 */
	DayCountFraction getDayCountFraction();

	/*********************** Build Methods  ***********************/
	RateIndex build();
	
	RateIndex.RateIndexBuilder toBuilder();
	
	static RateIndex.RateIndexBuilder builder() {
		return new RateIndex.RateIndexBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RateIndex> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends RateIndex> getType() {
		return RateIndex.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("instrumentId"), processor, InstrumentId.class, getInstrumentId());
		processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
		processRosetta(path.newSubPath("currency"), processor, IdentifiedCurrency.class, getCurrency());
		processRosetta(path.newSubPath("exchangeId"), processor, ExchangeId.class, getExchangeId());
		processRosetta(path.newSubPath("clearanceSystem"), processor, ClearanceSystem.class, getClearanceSystem());
		processRosetta(path.newSubPath("definition"), processor, ProductReference.class, getDefinition());
		processRosetta(path.newSubPath("floatingRateIndex"), processor, FloatingRateIndex.class, getFloatingRateIndex());
		processRosetta(path.newSubPath("term"), processor, Period.class, getTerm());
		processRosetta(path.newSubPath("paymentFrequency"), processor, Period.class, getPaymentFrequency());
		processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.class, getDayCountFraction());
	}
	

	/*********************** Builder Interface  ***********************/
	interface RateIndexBuilder extends RateIndex, UnderlyingAssetType.UnderlyingAssetTypeBuilder {
		FloatingRateIndex.FloatingRateIndexBuilder getOrCreateFloatingRateIndex();
		FloatingRateIndex.FloatingRateIndexBuilder getFloatingRateIndex();
		Period.PeriodBuilder getOrCreateTerm();
		Period.PeriodBuilder getTerm();
		Period.PeriodBuilder getOrCreatePaymentFrequency();
		Period.PeriodBuilder getPaymentFrequency();
		DayCountFraction.DayCountFractionBuilder getOrCreateDayCountFraction();
		DayCountFraction.DayCountFractionBuilder getDayCountFraction();
		RateIndex.RateIndexBuilder setId(String id);
		RateIndex.RateIndexBuilder addInstrumentId(InstrumentId instrumentId0);
		RateIndex.RateIndexBuilder addInstrumentId(InstrumentId instrumentId1, int _idx);
		RateIndex.RateIndexBuilder addInstrumentId(List<? extends InstrumentId> instrumentId2);
		RateIndex.RateIndexBuilder setInstrumentId(List<? extends InstrumentId> instrumentId3);
		RateIndex.RateIndexBuilder setDescription(String description);
		RateIndex.RateIndexBuilder setCurrency(IdentifiedCurrency currency);
		RateIndex.RateIndexBuilder setExchangeId(ExchangeId exchangeId);
		RateIndex.RateIndexBuilder setClearanceSystem(ClearanceSystem clearanceSystem);
		RateIndex.RateIndexBuilder setDefinition(ProductReference definition);
		RateIndex.RateIndexBuilder setFloatingRateIndex(FloatingRateIndex floatingRateIndex);
		RateIndex.RateIndexBuilder setTerm(Period term);
		RateIndex.RateIndexBuilder setPaymentFrequency(Period paymentFrequency);
		RateIndex.RateIndexBuilder setDayCountFraction(DayCountFraction dayCountFraction);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("instrumentId"), processor, InstrumentId.InstrumentIdBuilder.class, getInstrumentId());
			processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
			processRosetta(path.newSubPath("currency"), processor, IdentifiedCurrency.IdentifiedCurrencyBuilder.class, getCurrency());
			processRosetta(path.newSubPath("exchangeId"), processor, ExchangeId.ExchangeIdBuilder.class, getExchangeId());
			processRosetta(path.newSubPath("clearanceSystem"), processor, ClearanceSystem.ClearanceSystemBuilder.class, getClearanceSystem());
			processRosetta(path.newSubPath("definition"), processor, ProductReference.ProductReferenceBuilder.class, getDefinition());
			processRosetta(path.newSubPath("floatingRateIndex"), processor, FloatingRateIndex.FloatingRateIndexBuilder.class, getFloatingRateIndex());
			processRosetta(path.newSubPath("term"), processor, Period.PeriodBuilder.class, getTerm());
			processRosetta(path.newSubPath("paymentFrequency"), processor, Period.PeriodBuilder.class, getPaymentFrequency());
			processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.DayCountFractionBuilder.class, getDayCountFraction());
		}
		

		RateIndex.RateIndexBuilder prune();
	}

	/*********************** Immutable Implementation of RateIndex  ***********************/
	class RateIndexImpl extends UnderlyingAssetType.UnderlyingAssetTypeImpl implements RateIndex {
		private final FloatingRateIndex floatingRateIndex;
		private final Period term;
		private final Period paymentFrequency;
		private final DayCountFraction dayCountFraction;
		
		protected RateIndexImpl(RateIndex.RateIndexBuilder builder) {
			super(builder);
			this.floatingRateIndex = ofNullable(builder.getFloatingRateIndex()).map(f->f.build()).orElse(null);
			this.term = ofNullable(builder.getTerm()).map(f->f.build()).orElse(null);
			this.paymentFrequency = ofNullable(builder.getPaymentFrequency()).map(f->f.build()).orElse(null);
			this.dayCountFraction = ofNullable(builder.getDayCountFraction()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("floatingRateIndex")
		public FloatingRateIndex getFloatingRateIndex() {
			return floatingRateIndex;
		}
		
		@Override
		@RosettaAttribute("term")
		public Period getTerm() {
			return term;
		}
		
		@Override
		@RosettaAttribute("paymentFrequency")
		public Period getPaymentFrequency() {
			return paymentFrequency;
		}
		
		@Override
		@RosettaAttribute("dayCountFraction")
		public DayCountFraction getDayCountFraction() {
			return dayCountFraction;
		}
		
		@Override
		public RateIndex build() {
			return this;
		}
		
		@Override
		public RateIndex.RateIndexBuilder toBuilder() {
			RateIndex.RateIndexBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RateIndex.RateIndexBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getFloatingRateIndex()).ifPresent(builder::setFloatingRateIndex);
			ofNullable(getTerm()).ifPresent(builder::setTerm);
			ofNullable(getPaymentFrequency()).ifPresent(builder::setPaymentFrequency);
			ofNullable(getDayCountFraction()).ifPresent(builder::setDayCountFraction);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RateIndex _that = getType().cast(o);
		
			if (!Objects.equals(floatingRateIndex, _that.getFloatingRateIndex())) return false;
			if (!Objects.equals(term, _that.getTerm())) return false;
			if (!Objects.equals(paymentFrequency, _that.getPaymentFrequency())) return false;
			if (!Objects.equals(dayCountFraction, _that.getDayCountFraction())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (floatingRateIndex != null ? floatingRateIndex.hashCode() : 0);
			_result = 31 * _result + (term != null ? term.hashCode() : 0);
			_result = 31 * _result + (paymentFrequency != null ? paymentFrequency.hashCode() : 0);
			_result = 31 * _result + (dayCountFraction != null ? dayCountFraction.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RateIndex {" +
				"floatingRateIndex=" + this.floatingRateIndex + ", " +
				"term=" + this.term + ", " +
				"paymentFrequency=" + this.paymentFrequency + ", " +
				"dayCountFraction=" + this.dayCountFraction +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of RateIndex  ***********************/
	class RateIndexBuilderImpl extends UnderlyingAssetType.UnderlyingAssetTypeBuilderImpl  implements RateIndex.RateIndexBuilder {
	
		protected FloatingRateIndex.FloatingRateIndexBuilder floatingRateIndex;
		protected Period.PeriodBuilder term;
		protected Period.PeriodBuilder paymentFrequency;
		protected DayCountFraction.DayCountFractionBuilder dayCountFraction;
	
		public RateIndexBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("floatingRateIndex")
		public FloatingRateIndex.FloatingRateIndexBuilder getFloatingRateIndex() {
			return floatingRateIndex;
		}
		
		@Override
		public FloatingRateIndex.FloatingRateIndexBuilder getOrCreateFloatingRateIndex() {
			FloatingRateIndex.FloatingRateIndexBuilder result;
			if (floatingRateIndex!=null) {
				result = floatingRateIndex;
			}
			else {
				result = floatingRateIndex = FloatingRateIndex.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("term")
		public Period.PeriodBuilder getTerm() {
			return term;
		}
		
		@Override
		public Period.PeriodBuilder getOrCreateTerm() {
			Period.PeriodBuilder result;
			if (term!=null) {
				result = term;
			}
			else {
				result = term = Period.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("paymentFrequency")
		public Period.PeriodBuilder getPaymentFrequency() {
			return paymentFrequency;
		}
		
		@Override
		public Period.PeriodBuilder getOrCreatePaymentFrequency() {
			Period.PeriodBuilder result;
			if (paymentFrequency!=null) {
				result = paymentFrequency;
			}
			else {
				result = paymentFrequency = Period.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("dayCountFraction")
		public DayCountFraction.DayCountFractionBuilder getDayCountFraction() {
			return dayCountFraction;
		}
		
		@Override
		public DayCountFraction.DayCountFractionBuilder getOrCreateDayCountFraction() {
			DayCountFraction.DayCountFractionBuilder result;
			if (dayCountFraction!=null) {
				result = dayCountFraction;
			}
			else {
				result = dayCountFraction = DayCountFraction.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public RateIndex.RateIndexBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		public RateIndex.RateIndexBuilder addInstrumentId(InstrumentId instrumentId) {
			if (instrumentId!=null) this.instrumentId.add(instrumentId.toBuilder());
			return this;
		}
		
		@Override
		public RateIndex.RateIndexBuilder addInstrumentId(InstrumentId instrumentId, int _idx) {
			getIndex(this.instrumentId, _idx, () -> instrumentId.toBuilder());
			return this;
		}
		@Override 
		public RateIndex.RateIndexBuilder addInstrumentId(List<? extends InstrumentId> instrumentIds) {
			if (instrumentIds != null) {
				for (InstrumentId toAdd : instrumentIds) {
					this.instrumentId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("instrumentId")
		public RateIndex.RateIndexBuilder setInstrumentId(List<? extends InstrumentId> instrumentIds) {
			if (instrumentIds == null)  {
				this.instrumentId = new ArrayList<>();
			}
			else {
				this.instrumentId = instrumentIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("description")
		public RateIndex.RateIndexBuilder setDescription(String description) {
			this.description = description==null?null:description;
			return this;
		}
		@Override
		@RosettaAttribute("currency")
		public RateIndex.RateIndexBuilder setCurrency(IdentifiedCurrency currency) {
			this.currency = currency==null?null:currency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("exchangeId")
		public RateIndex.RateIndexBuilder setExchangeId(ExchangeId exchangeId) {
			this.exchangeId = exchangeId==null?null:exchangeId.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("clearanceSystem")
		public RateIndex.RateIndexBuilder setClearanceSystem(ClearanceSystem clearanceSystem) {
			this.clearanceSystem = clearanceSystem==null?null:clearanceSystem.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("definition")
		public RateIndex.RateIndexBuilder setDefinition(ProductReference definition) {
			this.definition = definition==null?null:definition.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("floatingRateIndex")
		public RateIndex.RateIndexBuilder setFloatingRateIndex(FloatingRateIndex floatingRateIndex) {
			this.floatingRateIndex = floatingRateIndex==null?null:floatingRateIndex.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("term")
		public RateIndex.RateIndexBuilder setTerm(Period term) {
			this.term = term==null?null:term.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("paymentFrequency")
		public RateIndex.RateIndexBuilder setPaymentFrequency(Period paymentFrequency) {
			this.paymentFrequency = paymentFrequency==null?null:paymentFrequency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("dayCountFraction")
		public RateIndex.RateIndexBuilder setDayCountFraction(DayCountFraction dayCountFraction) {
			this.dayCountFraction = dayCountFraction==null?null:dayCountFraction.toBuilder();
			return this;
		}
		
		@Override
		public RateIndex build() {
			return new RateIndex.RateIndexImpl(this);
		}
		
		@Override
		public RateIndex.RateIndexBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RateIndex.RateIndexBuilder prune() {
			super.prune();
			if (floatingRateIndex!=null && !floatingRateIndex.prune().hasData()) floatingRateIndex = null;
			if (term!=null && !term.prune().hasData()) term = null;
			if (paymentFrequency!=null && !paymentFrequency.prune().hasData()) paymentFrequency = null;
			if (dayCountFraction!=null && !dayCountFraction.prune().hasData()) dayCountFraction = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getFloatingRateIndex()!=null && getFloatingRateIndex().hasData()) return true;
			if (getTerm()!=null && getTerm().hasData()) return true;
			if (getPaymentFrequency()!=null && getPaymentFrequency().hasData()) return true;
			if (getDayCountFraction()!=null && getDayCountFraction().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RateIndex.RateIndexBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			RateIndex.RateIndexBuilder o = (RateIndex.RateIndexBuilder) other;
			
			merger.mergeRosetta(getFloatingRateIndex(), o.getFloatingRateIndex(), this::setFloatingRateIndex);
			merger.mergeRosetta(getTerm(), o.getTerm(), this::setTerm);
			merger.mergeRosetta(getPaymentFrequency(), o.getPaymentFrequency(), this::setPaymentFrequency);
			merger.mergeRosetta(getDayCountFraction(), o.getDayCountFraction(), this::setDayCountFraction);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RateIndex _that = getType().cast(o);
		
			if (!Objects.equals(floatingRateIndex, _that.getFloatingRateIndex())) return false;
			if (!Objects.equals(term, _that.getTerm())) return false;
			if (!Objects.equals(paymentFrequency, _that.getPaymentFrequency())) return false;
			if (!Objects.equals(dayCountFraction, _that.getDayCountFraction())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (floatingRateIndex != null ? floatingRateIndex.hashCode() : 0);
			_result = 31 * _result + (term != null ? term.hashCode() : 0);
			_result = 31 * _result + (paymentFrequency != null ? paymentFrequency.hashCode() : 0);
			_result = 31 * _result + (dayCountFraction != null ? dayCountFraction.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RateIndexBuilder {" +
				"floatingRateIndex=" + this.floatingRateIndex + ", " +
				"term=" + this.term + ", " +
				"paymentFrequency=" + this.paymentFrequency + ", " +
				"dayCountFraction=" + this.dayCountFraction +
			'}' + " " + super.toString();
		}
	}
}
