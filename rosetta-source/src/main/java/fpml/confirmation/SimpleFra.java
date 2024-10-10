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
import fpml.confirmation.IdentifiedCurrency;
import fpml.confirmation.InstrumentId;
import fpml.confirmation.Period;
import fpml.confirmation.ProductReference;
import fpml.confirmation.SimpleFra;
import fpml.confirmation.SimpleFra.SimpleFraBuilder;
import fpml.confirmation.SimpleFra.SimpleFraBuilderImpl;
import fpml.confirmation.SimpleFra.SimpleFraImpl;
import fpml.confirmation.UnderlyingAssetType;
import fpml.confirmation.UnderlyingAssetType.UnderlyingAssetTypeBuilder;
import fpml.confirmation.UnderlyingAssetType.UnderlyingAssetTypeBuilderImpl;
import fpml.confirmation.UnderlyingAssetType.UnderlyingAssetTypeImpl;
import fpml.confirmation.meta.SimpleFraMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Identifies a simple underlying asset that is a forward rate agreement.
 * @version ${project.version}
 */
@RosettaDataType(value="SimpleFra", builder=SimpleFra.SimpleFraBuilderImpl.class, version="${project.version}")
public interface SimpleFra extends UnderlyingAssetType {

	SimpleFraMeta metaData = new SimpleFraMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies the start term of the simple fra, e.g. 3M.
	 */
	Period getStartTerm();
	/**
	 * Specifies the end term of the simple fra, e.g. 9M.
	 */
	Period getEndTerm();
	/**
	 * The day count basis for the FRA.
	 */
	DayCountFraction getDayCountFraction();

	/*********************** Build Methods  ***********************/
	SimpleFra build();
	
	SimpleFra.SimpleFraBuilder toBuilder();
	
	static SimpleFra.SimpleFraBuilder builder() {
		return new SimpleFra.SimpleFraBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SimpleFra> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends SimpleFra> getType() {
		return SimpleFra.class;
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
		processRosetta(path.newSubPath("startTerm"), processor, Period.class, getStartTerm());
		processRosetta(path.newSubPath("endTerm"), processor, Period.class, getEndTerm());
		processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.class, getDayCountFraction());
	}
	

	/*********************** Builder Interface  ***********************/
	interface SimpleFraBuilder extends SimpleFra, UnderlyingAssetType.UnderlyingAssetTypeBuilder {
		Period.PeriodBuilder getOrCreateStartTerm();
		Period.PeriodBuilder getStartTerm();
		Period.PeriodBuilder getOrCreateEndTerm();
		Period.PeriodBuilder getEndTerm();
		DayCountFraction.DayCountFractionBuilder getOrCreateDayCountFraction();
		DayCountFraction.DayCountFractionBuilder getDayCountFraction();
		SimpleFra.SimpleFraBuilder setId(String id);
		SimpleFra.SimpleFraBuilder addInstrumentId(InstrumentId instrumentId0);
		SimpleFra.SimpleFraBuilder addInstrumentId(InstrumentId instrumentId1, int _idx);
		SimpleFra.SimpleFraBuilder addInstrumentId(List<? extends InstrumentId> instrumentId2);
		SimpleFra.SimpleFraBuilder setInstrumentId(List<? extends InstrumentId> instrumentId3);
		SimpleFra.SimpleFraBuilder setDescription(String description);
		SimpleFra.SimpleFraBuilder setCurrency(IdentifiedCurrency currency);
		SimpleFra.SimpleFraBuilder setExchangeId(ExchangeId exchangeId);
		SimpleFra.SimpleFraBuilder setClearanceSystem(ClearanceSystem clearanceSystem);
		SimpleFra.SimpleFraBuilder setDefinition(ProductReference definition);
		SimpleFra.SimpleFraBuilder setStartTerm(Period startTerm);
		SimpleFra.SimpleFraBuilder setEndTerm(Period endTerm);
		SimpleFra.SimpleFraBuilder setDayCountFraction(DayCountFraction dayCountFraction);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("instrumentId"), processor, InstrumentId.InstrumentIdBuilder.class, getInstrumentId());
			processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
			processRosetta(path.newSubPath("currency"), processor, IdentifiedCurrency.IdentifiedCurrencyBuilder.class, getCurrency());
			processRosetta(path.newSubPath("exchangeId"), processor, ExchangeId.ExchangeIdBuilder.class, getExchangeId());
			processRosetta(path.newSubPath("clearanceSystem"), processor, ClearanceSystem.ClearanceSystemBuilder.class, getClearanceSystem());
			processRosetta(path.newSubPath("definition"), processor, ProductReference.ProductReferenceBuilder.class, getDefinition());
			processRosetta(path.newSubPath("startTerm"), processor, Period.PeriodBuilder.class, getStartTerm());
			processRosetta(path.newSubPath("endTerm"), processor, Period.PeriodBuilder.class, getEndTerm());
			processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.DayCountFractionBuilder.class, getDayCountFraction());
		}
		

		SimpleFra.SimpleFraBuilder prune();
	}

	/*********************** Immutable Implementation of SimpleFra  ***********************/
	class SimpleFraImpl extends UnderlyingAssetType.UnderlyingAssetTypeImpl implements SimpleFra {
		private final Period startTerm;
		private final Period endTerm;
		private final DayCountFraction dayCountFraction;
		
		protected SimpleFraImpl(SimpleFra.SimpleFraBuilder builder) {
			super(builder);
			this.startTerm = ofNullable(builder.getStartTerm()).map(f->f.build()).orElse(null);
			this.endTerm = ofNullable(builder.getEndTerm()).map(f->f.build()).orElse(null);
			this.dayCountFraction = ofNullable(builder.getDayCountFraction()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("startTerm")
		public Period getStartTerm() {
			return startTerm;
		}
		
		@Override
		@RosettaAttribute("endTerm")
		public Period getEndTerm() {
			return endTerm;
		}
		
		@Override
		@RosettaAttribute("dayCountFraction")
		public DayCountFraction getDayCountFraction() {
			return dayCountFraction;
		}
		
		@Override
		public SimpleFra build() {
			return this;
		}
		
		@Override
		public SimpleFra.SimpleFraBuilder toBuilder() {
			SimpleFra.SimpleFraBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SimpleFra.SimpleFraBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getStartTerm()).ifPresent(builder::setStartTerm);
			ofNullable(getEndTerm()).ifPresent(builder::setEndTerm);
			ofNullable(getDayCountFraction()).ifPresent(builder::setDayCountFraction);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			SimpleFra _that = getType().cast(o);
		
			if (!Objects.equals(startTerm, _that.getStartTerm())) return false;
			if (!Objects.equals(endTerm, _that.getEndTerm())) return false;
			if (!Objects.equals(dayCountFraction, _that.getDayCountFraction())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (startTerm != null ? startTerm.hashCode() : 0);
			_result = 31 * _result + (endTerm != null ? endTerm.hashCode() : 0);
			_result = 31 * _result + (dayCountFraction != null ? dayCountFraction.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SimpleFra {" +
				"startTerm=" + this.startTerm + ", " +
				"endTerm=" + this.endTerm + ", " +
				"dayCountFraction=" + this.dayCountFraction +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of SimpleFra  ***********************/
	class SimpleFraBuilderImpl extends UnderlyingAssetType.UnderlyingAssetTypeBuilderImpl  implements SimpleFra.SimpleFraBuilder {
	
		protected Period.PeriodBuilder startTerm;
		protected Period.PeriodBuilder endTerm;
		protected DayCountFraction.DayCountFractionBuilder dayCountFraction;
	
		public SimpleFraBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("startTerm")
		public Period.PeriodBuilder getStartTerm() {
			return startTerm;
		}
		
		@Override
		public Period.PeriodBuilder getOrCreateStartTerm() {
			Period.PeriodBuilder result;
			if (startTerm!=null) {
				result = startTerm;
			}
			else {
				result = startTerm = Period.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("endTerm")
		public Period.PeriodBuilder getEndTerm() {
			return endTerm;
		}
		
		@Override
		public Period.PeriodBuilder getOrCreateEndTerm() {
			Period.PeriodBuilder result;
			if (endTerm!=null) {
				result = endTerm;
			}
			else {
				result = endTerm = Period.builder();
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
		public SimpleFra.SimpleFraBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		public SimpleFra.SimpleFraBuilder addInstrumentId(InstrumentId instrumentId) {
			if (instrumentId!=null) this.instrumentId.add(instrumentId.toBuilder());
			return this;
		}
		
		@Override
		public SimpleFra.SimpleFraBuilder addInstrumentId(InstrumentId instrumentId, int _idx) {
			getIndex(this.instrumentId, _idx, () -> instrumentId.toBuilder());
			return this;
		}
		@Override 
		public SimpleFra.SimpleFraBuilder addInstrumentId(List<? extends InstrumentId> instrumentIds) {
			if (instrumentIds != null) {
				for (InstrumentId toAdd : instrumentIds) {
					this.instrumentId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("instrumentId")
		public SimpleFra.SimpleFraBuilder setInstrumentId(List<? extends InstrumentId> instrumentIds) {
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
		public SimpleFra.SimpleFraBuilder setDescription(String description) {
			this.description = description==null?null:description;
			return this;
		}
		@Override
		@RosettaAttribute("currency")
		public SimpleFra.SimpleFraBuilder setCurrency(IdentifiedCurrency currency) {
			this.currency = currency==null?null:currency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("exchangeId")
		public SimpleFra.SimpleFraBuilder setExchangeId(ExchangeId exchangeId) {
			this.exchangeId = exchangeId==null?null:exchangeId.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("clearanceSystem")
		public SimpleFra.SimpleFraBuilder setClearanceSystem(ClearanceSystem clearanceSystem) {
			this.clearanceSystem = clearanceSystem==null?null:clearanceSystem.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("definition")
		public SimpleFra.SimpleFraBuilder setDefinition(ProductReference definition) {
			this.definition = definition==null?null:definition.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("startTerm")
		public SimpleFra.SimpleFraBuilder setStartTerm(Period startTerm) {
			this.startTerm = startTerm==null?null:startTerm.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("endTerm")
		public SimpleFra.SimpleFraBuilder setEndTerm(Period endTerm) {
			this.endTerm = endTerm==null?null:endTerm.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("dayCountFraction")
		public SimpleFra.SimpleFraBuilder setDayCountFraction(DayCountFraction dayCountFraction) {
			this.dayCountFraction = dayCountFraction==null?null:dayCountFraction.toBuilder();
			return this;
		}
		
		@Override
		public SimpleFra build() {
			return new SimpleFra.SimpleFraImpl(this);
		}
		
		@Override
		public SimpleFra.SimpleFraBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SimpleFra.SimpleFraBuilder prune() {
			super.prune();
			if (startTerm!=null && !startTerm.prune().hasData()) startTerm = null;
			if (endTerm!=null && !endTerm.prune().hasData()) endTerm = null;
			if (dayCountFraction!=null && !dayCountFraction.prune().hasData()) dayCountFraction = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getStartTerm()!=null && getStartTerm().hasData()) return true;
			if (getEndTerm()!=null && getEndTerm().hasData()) return true;
			if (getDayCountFraction()!=null && getDayCountFraction().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SimpleFra.SimpleFraBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			SimpleFra.SimpleFraBuilder o = (SimpleFra.SimpleFraBuilder) other;
			
			merger.mergeRosetta(getStartTerm(), o.getStartTerm(), this::setStartTerm);
			merger.mergeRosetta(getEndTerm(), o.getEndTerm(), this::setEndTerm);
			merger.mergeRosetta(getDayCountFraction(), o.getDayCountFraction(), this::setDayCountFraction);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			SimpleFra _that = getType().cast(o);
		
			if (!Objects.equals(startTerm, _that.getStartTerm())) return false;
			if (!Objects.equals(endTerm, _that.getEndTerm())) return false;
			if (!Objects.equals(dayCountFraction, _that.getDayCountFraction())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (startTerm != null ? startTerm.hashCode() : 0);
			_result = 31 * _result + (endTerm != null ? endTerm.hashCode() : 0);
			_result = 31 * _result + (dayCountFraction != null ? dayCountFraction.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SimpleFraBuilder {" +
				"startTerm=" + this.startTerm + ", " +
				"endTerm=" + this.endTerm + ", " +
				"dayCountFraction=" + this.dayCountFraction +
			'}' + " " + super.toString();
		}
	}
}
