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
import fpml.confirmation.SimpleIrSwap.SimpleIrSwapBuilderImpl;
import fpml.confirmation.meta.SimpleIRSwapMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="SimpleIRSwap", builder= SimpleIrSwapBuilderImpl.class, version="${project.version}")
public interface SimpleIrSwap extends UnderlyingAssetType {

	SimpleIRSwapMeta metaData = new SimpleIRSwapMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies the term of the simple swap, e.g. 5Y.
	 */
	Period getTerm();
	/**
	 * Specifies the frequency at which the swap pays, e.g. 6M.
	 */
	Period getPaymentFrequency();
	/**
	 * The day count basis for the swap.
	 */
	DayCountFraction getDayCountFraction();

	/*********************** Build Methods  ***********************/
	SimpleIrSwap build();
	
	SimpleIrSwapBuilder toBuilder();
	
	static SimpleIrSwapBuilder builder() {
		return new SimpleIrSwapBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SimpleIrSwap> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends SimpleIrSwap> getType() {
		return SimpleIrSwap.class;
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
		processRosetta(path.newSubPath("term"), processor, Period.class, getTerm());
		processRosetta(path.newSubPath("paymentFrequency"), processor, Period.class, getPaymentFrequency());
		processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.class, getDayCountFraction());
	}
	

	/*********************** Builder Interface  ***********************/
	interface SimpleIrSwapBuilder extends SimpleIrSwap, UnderlyingAssetType.UnderlyingAssetTypeBuilder {
		Period.PeriodBuilder getOrCreateTerm();
		Period.PeriodBuilder getTerm();
		Period.PeriodBuilder getOrCreatePaymentFrequency();
		Period.PeriodBuilder getPaymentFrequency();
		DayCountFraction.DayCountFractionBuilder getOrCreateDayCountFraction();
		DayCountFraction.DayCountFractionBuilder getDayCountFraction();
		SimpleIrSwapBuilder setId(String id);
		SimpleIrSwapBuilder addInstrumentId(InstrumentId instrumentId0);
		SimpleIrSwapBuilder addInstrumentId(InstrumentId instrumentId1, int _idx);
		SimpleIrSwapBuilder addInstrumentId(List<? extends InstrumentId> instrumentId2);
		SimpleIrSwapBuilder setInstrumentId(List<? extends InstrumentId> instrumentId3);
		SimpleIrSwapBuilder setDescription(String description);
		SimpleIrSwapBuilder setCurrency(IdentifiedCurrency currency);
		SimpleIrSwapBuilder setExchangeId(ExchangeId exchangeId);
		SimpleIrSwapBuilder setClearanceSystem(ClearanceSystem clearanceSystem);
		SimpleIrSwapBuilder setDefinition(ProductReference definition);
		SimpleIrSwapBuilder setTerm(Period term);
		SimpleIrSwapBuilder setPaymentFrequency(Period paymentFrequency);
		SimpleIrSwapBuilder setDayCountFraction(DayCountFraction dayCountFraction);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("instrumentId"), processor, InstrumentId.InstrumentIdBuilder.class, getInstrumentId());
			processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
			processRosetta(path.newSubPath("currency"), processor, IdentifiedCurrency.IdentifiedCurrencyBuilder.class, getCurrency());
			processRosetta(path.newSubPath("exchangeId"), processor, ExchangeId.ExchangeIdBuilder.class, getExchangeId());
			processRosetta(path.newSubPath("clearanceSystem"), processor, ClearanceSystem.ClearanceSystemBuilder.class, getClearanceSystem());
			processRosetta(path.newSubPath("definition"), processor, ProductReference.ProductReferenceBuilder.class, getDefinition());
			processRosetta(path.newSubPath("term"), processor, Period.PeriodBuilder.class, getTerm());
			processRosetta(path.newSubPath("paymentFrequency"), processor, Period.PeriodBuilder.class, getPaymentFrequency());
			processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.DayCountFractionBuilder.class, getDayCountFraction());
		}
		

		SimpleIrSwapBuilder prune();
	}

	/*********************** Immutable Implementation of SimpleIRSwap  ***********************/
	class SimpleIrSwapImpl extends UnderlyingAssetType.UnderlyingAssetTypeImpl implements SimpleIrSwap {
		private final Period term;
		private final Period paymentFrequency;
		private final DayCountFraction dayCountFraction;
		
		protected SimpleIrSwapImpl(SimpleIrSwapBuilder builder) {
			super(builder);
			this.term = ofNullable(builder.getTerm()).map(f->f.build()).orElse(null);
			this.paymentFrequency = ofNullable(builder.getPaymentFrequency()).map(f->f.build()).orElse(null);
			this.dayCountFraction = ofNullable(builder.getDayCountFraction()).map(f->f.build()).orElse(null);
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
		public SimpleIrSwap build() {
			return this;
		}
		
		@Override
		public SimpleIrSwapBuilder toBuilder() {
			SimpleIrSwapBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SimpleIrSwapBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getTerm()).ifPresent(builder::setTerm);
			ofNullable(getPaymentFrequency()).ifPresent(builder::setPaymentFrequency);
			ofNullable(getDayCountFraction()).ifPresent(builder::setDayCountFraction);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			SimpleIrSwap _that = getType().cast(o);
		
			if (!Objects.equals(term, _that.getTerm())) return false;
			if (!Objects.equals(paymentFrequency, _that.getPaymentFrequency())) return false;
			if (!Objects.equals(dayCountFraction, _that.getDayCountFraction())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (term != null ? term.hashCode() : 0);
			_result = 31 * _result + (paymentFrequency != null ? paymentFrequency.hashCode() : 0);
			_result = 31 * _result + (dayCountFraction != null ? dayCountFraction.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SimpleIRSwap {" +
				"term=" + this.term + ", " +
				"paymentFrequency=" + this.paymentFrequency + ", " +
				"dayCountFraction=" + this.dayCountFraction +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of SimpleIRSwap  ***********************/
	class SimpleIrSwapBuilderImpl extends UnderlyingAssetType.UnderlyingAssetTypeBuilderImpl  implements SimpleIrSwapBuilder {
	
		protected Period.PeriodBuilder term;
		protected Period.PeriodBuilder paymentFrequency;
		protected DayCountFraction.DayCountFractionBuilder dayCountFraction;
	
		public SimpleIrSwapBuilderImpl() {
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
		public SimpleIrSwapBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		public SimpleIrSwapBuilder addInstrumentId(InstrumentId instrumentId) {
			if (instrumentId!=null) this.instrumentId.add(instrumentId.toBuilder());
			return this;
		}
		
		@Override
		public SimpleIrSwapBuilder addInstrumentId(InstrumentId instrumentId, int _idx) {
			getIndex(this.instrumentId, _idx, () -> instrumentId.toBuilder());
			return this;
		}
		@Override 
		public SimpleIrSwapBuilder addInstrumentId(List<? extends InstrumentId> instrumentIds) {
			if (instrumentIds != null) {
				for (InstrumentId toAdd : instrumentIds) {
					this.instrumentId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("instrumentId")
		public SimpleIrSwapBuilder setInstrumentId(List<? extends InstrumentId> instrumentIds) {
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
		public SimpleIrSwapBuilder setDescription(String description) {
			this.description = description==null?null:description;
			return this;
		}
		@Override
		@RosettaAttribute("currency")
		public SimpleIrSwapBuilder setCurrency(IdentifiedCurrency currency) {
			this.currency = currency==null?null:currency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("exchangeId")
		public SimpleIrSwapBuilder setExchangeId(ExchangeId exchangeId) {
			this.exchangeId = exchangeId==null?null:exchangeId.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("clearanceSystem")
		public SimpleIrSwapBuilder setClearanceSystem(ClearanceSystem clearanceSystem) {
			this.clearanceSystem = clearanceSystem==null?null:clearanceSystem.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("definition")
		public SimpleIrSwapBuilder setDefinition(ProductReference definition) {
			this.definition = definition==null?null:definition.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("term")
		public SimpleIrSwapBuilder setTerm(Period term) {
			this.term = term==null?null:term.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("paymentFrequency")
		public SimpleIrSwapBuilder setPaymentFrequency(Period paymentFrequency) {
			this.paymentFrequency = paymentFrequency==null?null:paymentFrequency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("dayCountFraction")
		public SimpleIrSwapBuilder setDayCountFraction(DayCountFraction dayCountFraction) {
			this.dayCountFraction = dayCountFraction==null?null:dayCountFraction.toBuilder();
			return this;
		}
		
		@Override
		public SimpleIrSwap build() {
			return new SimpleIrSwapImpl(this);
		}
		
		@Override
		public SimpleIrSwapBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SimpleIrSwapBuilder prune() {
			super.prune();
			if (term!=null && !term.prune().hasData()) term = null;
			if (paymentFrequency!=null && !paymentFrequency.prune().hasData()) paymentFrequency = null;
			if (dayCountFraction!=null && !dayCountFraction.prune().hasData()) dayCountFraction = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getTerm()!=null && getTerm().hasData()) return true;
			if (getPaymentFrequency()!=null && getPaymentFrequency().hasData()) return true;
			if (getDayCountFraction()!=null && getDayCountFraction().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SimpleIrSwapBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			SimpleIrSwapBuilder o = (SimpleIrSwapBuilder) other;
			
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
		
			SimpleIrSwap _that = getType().cast(o);
		
			if (!Objects.equals(term, _that.getTerm())) return false;
			if (!Objects.equals(paymentFrequency, _that.getPaymentFrequency())) return false;
			if (!Objects.equals(dayCountFraction, _that.getDayCountFraction())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (term != null ? term.hashCode() : 0);
			_result = 31 * _result + (paymentFrequency != null ? paymentFrequency.hashCode() : 0);
			_result = 31 * _result + (dayCountFraction != null ? dayCountFraction.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SimpleIRSwapBuilder {" +
				"term=" + this.term + ", " +
				"paymentFrequency=" + this.paymentFrequency + ", " +
				"dayCountFraction=" + this.dayCountFraction +
			'}' + " " + super.toString();
		}
	}
}
