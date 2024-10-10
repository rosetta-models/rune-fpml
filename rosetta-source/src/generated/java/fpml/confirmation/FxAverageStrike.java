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
import fpml.confirmation.FxAverageStrike;
import fpml.confirmation.FxAverageStrike.FxAverageStrikeBuilder;
import fpml.confirmation.FxAverageStrike.FxAverageStrikeBuilderImpl;
import fpml.confirmation.FxAverageStrike.FxAverageStrikeImpl;
import fpml.confirmation.FxAveragingMethodEnum;
import fpml.confirmation.FxAveragingProcess;
import fpml.confirmation.FxAveragingProcess.FxAveragingProcessBuilder;
import fpml.confirmation.FxAveragingProcess.FxAveragingProcessBuilderImpl;
import fpml.confirmation.FxAveragingProcess.FxAveragingProcessImpl;
import fpml.confirmation.FxCrossRateObservable;
import fpml.confirmation.FxInformationSource;
import fpml.confirmation.FxWeightedFixingSchedule;
import fpml.confirmation.QuotedCurrencyPair;
import fpml.confirmation.meta.FxAverageStrikeMeta;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="FxAverageStrike", builder=FxAverageStrike.FxAverageStrikeBuilderImpl.class, version="${project.version}")
public interface FxAverageStrike extends FxAveragingProcess {

	FxAverageStrikeMeta metaData = new FxAverageStrikeMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A layer an Adjustment on the top of the average of the fixings across the schedule.
	 */
	BigDecimal getStrikeAdjustment();

	/*********************** Build Methods  ***********************/
	FxAverageStrike build();
	
	FxAverageStrike.FxAverageStrikeBuilder toBuilder();
	
	static FxAverageStrike.FxAverageStrikeBuilder builder() {
		return new FxAverageStrike.FxAverageStrikeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxAverageStrike> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxAverageStrike> getType() {
		return FxAverageStrike.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("quotedCurrencyPair"), processor, QuotedCurrencyPair.class, getQuotedCurrencyPair());
		processRosetta(path.newSubPath("informationSource"), processor, FxInformationSource.class, getInformationSource());
		processRosetta(path.newSubPath("crossRate"), processor, FxCrossRateObservable.class, getCrossRate());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("fixingSchedule"), processor, FxWeightedFixingSchedule.class, getFixingSchedule());
		processor.processBasic(path.newSubPath("averagingMethod"), FxAveragingMethodEnum.class, getAveragingMethod(), this);
		processor.processBasic(path.newSubPath("precision"), Integer.class, getPrecision(), this);
		processor.processBasic(path.newSubPath("strikeAdjustment"), BigDecimal.class, getStrikeAdjustment(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxAverageStrikeBuilder extends FxAverageStrike, FxAveragingProcess.FxAveragingProcessBuilder {
		FxAverageStrike.FxAverageStrikeBuilder setQuotedCurrencyPair(QuotedCurrencyPair quotedCurrencyPair);
		FxAverageStrike.FxAverageStrikeBuilder setInformationSource(FxInformationSource informationSource);
		FxAverageStrike.FxAverageStrikeBuilder addCrossRate(FxCrossRateObservable crossRate0);
		FxAverageStrike.FxAverageStrikeBuilder addCrossRate(FxCrossRateObservable crossRate1, int _idx);
		FxAverageStrike.FxAverageStrikeBuilder addCrossRate(List<? extends FxCrossRateObservable> crossRate2);
		FxAverageStrike.FxAverageStrikeBuilder setCrossRate(List<? extends FxCrossRateObservable> crossRate3);
		FxAverageStrike.FxAverageStrikeBuilder setId(String id);
		FxAverageStrike.FxAverageStrikeBuilder setFixingSchedule(FxWeightedFixingSchedule fixingSchedule);
		FxAverageStrike.FxAverageStrikeBuilder setAveragingMethod(FxAveragingMethodEnum averagingMethod);
		FxAverageStrike.FxAverageStrikeBuilder setPrecision(Integer precision);
		FxAverageStrike.FxAverageStrikeBuilder setStrikeAdjustment(BigDecimal strikeAdjustment);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("quotedCurrencyPair"), processor, QuotedCurrencyPair.QuotedCurrencyPairBuilder.class, getQuotedCurrencyPair());
			processRosetta(path.newSubPath("informationSource"), processor, FxInformationSource.FxInformationSourceBuilder.class, getInformationSource());
			processRosetta(path.newSubPath("crossRate"), processor, FxCrossRateObservable.FxCrossRateObservableBuilder.class, getCrossRate());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("fixingSchedule"), processor, FxWeightedFixingSchedule.FxWeightedFixingScheduleBuilder.class, getFixingSchedule());
			processor.processBasic(path.newSubPath("averagingMethod"), FxAveragingMethodEnum.class, getAveragingMethod(), this);
			processor.processBasic(path.newSubPath("precision"), Integer.class, getPrecision(), this);
			processor.processBasic(path.newSubPath("strikeAdjustment"), BigDecimal.class, getStrikeAdjustment(), this);
		}
		

		FxAverageStrike.FxAverageStrikeBuilder prune();
	}

	/*********************** Immutable Implementation of FxAverageStrike  ***********************/
	class FxAverageStrikeImpl extends FxAveragingProcess.FxAveragingProcessImpl implements FxAverageStrike {
		private final BigDecimal strikeAdjustment;
		
		protected FxAverageStrikeImpl(FxAverageStrike.FxAverageStrikeBuilder builder) {
			super(builder);
			this.strikeAdjustment = builder.getStrikeAdjustment();
		}
		
		@Override
		@RosettaAttribute("strikeAdjustment")
		public BigDecimal getStrikeAdjustment() {
			return strikeAdjustment;
		}
		
		@Override
		public FxAverageStrike build() {
			return this;
		}
		
		@Override
		public FxAverageStrike.FxAverageStrikeBuilder toBuilder() {
			FxAverageStrike.FxAverageStrikeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxAverageStrike.FxAverageStrikeBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getStrikeAdjustment()).ifPresent(builder::setStrikeAdjustment);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxAverageStrike _that = getType().cast(o);
		
			if (!Objects.equals(strikeAdjustment, _that.getStrikeAdjustment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (strikeAdjustment != null ? strikeAdjustment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxAverageStrike {" +
				"strikeAdjustment=" + this.strikeAdjustment +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxAverageStrike  ***********************/
	class FxAverageStrikeBuilderImpl extends FxAveragingProcess.FxAveragingProcessBuilderImpl  implements FxAverageStrike.FxAverageStrikeBuilder {
	
		protected BigDecimal strikeAdjustment;
	
		public FxAverageStrikeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("strikeAdjustment")
		public BigDecimal getStrikeAdjustment() {
			return strikeAdjustment;
		}
		
		@Override
		@RosettaAttribute("quotedCurrencyPair")
		public FxAverageStrike.FxAverageStrikeBuilder setQuotedCurrencyPair(QuotedCurrencyPair quotedCurrencyPair) {
			this.quotedCurrencyPair = quotedCurrencyPair==null?null:quotedCurrencyPair.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("informationSource")
		public FxAverageStrike.FxAverageStrikeBuilder setInformationSource(FxInformationSource informationSource) {
			this.informationSource = informationSource==null?null:informationSource.toBuilder();
			return this;
		}
		@Override
		public FxAverageStrike.FxAverageStrikeBuilder addCrossRate(FxCrossRateObservable crossRate) {
			if (crossRate!=null) this.crossRate.add(crossRate.toBuilder());
			return this;
		}
		
		@Override
		public FxAverageStrike.FxAverageStrikeBuilder addCrossRate(FxCrossRateObservable crossRate, int _idx) {
			getIndex(this.crossRate, _idx, () -> crossRate.toBuilder());
			return this;
		}
		@Override 
		public FxAverageStrike.FxAverageStrikeBuilder addCrossRate(List<? extends FxCrossRateObservable> crossRates) {
			if (crossRates != null) {
				for (FxCrossRateObservable toAdd : crossRates) {
					this.crossRate.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("crossRate")
		public FxAverageStrike.FxAverageStrikeBuilder setCrossRate(List<? extends FxCrossRateObservable> crossRates) {
			if (crossRates == null)  {
				this.crossRate = new ArrayList<>();
			}
			else {
				this.crossRate = crossRates.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("id")
		public FxAverageStrike.FxAverageStrikeBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("fixingSchedule")
		public FxAverageStrike.FxAverageStrikeBuilder setFixingSchedule(FxWeightedFixingSchedule fixingSchedule) {
			this.fixingSchedule = fixingSchedule==null?null:fixingSchedule.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("averagingMethod")
		public FxAverageStrike.FxAverageStrikeBuilder setAveragingMethod(FxAveragingMethodEnum averagingMethod) {
			this.averagingMethod = averagingMethod==null?null:averagingMethod;
			return this;
		}
		@Override
		@RosettaAttribute("precision")
		public FxAverageStrike.FxAverageStrikeBuilder setPrecision(Integer precision) {
			this.precision = precision==null?null:precision;
			return this;
		}
		@Override
		@RosettaAttribute("strikeAdjustment")
		public FxAverageStrike.FxAverageStrikeBuilder setStrikeAdjustment(BigDecimal strikeAdjustment) {
			this.strikeAdjustment = strikeAdjustment==null?null:strikeAdjustment;
			return this;
		}
		
		@Override
		public FxAverageStrike build() {
			return new FxAverageStrike.FxAverageStrikeImpl(this);
		}
		
		@Override
		public FxAverageStrike.FxAverageStrikeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAverageStrike.FxAverageStrikeBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getStrikeAdjustment()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAverageStrike.FxAverageStrikeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FxAverageStrike.FxAverageStrikeBuilder o = (FxAverageStrike.FxAverageStrikeBuilder) other;
			
			
			merger.mergeBasic(getStrikeAdjustment(), o.getStrikeAdjustment(), this::setStrikeAdjustment);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxAverageStrike _that = getType().cast(o);
		
			if (!Objects.equals(strikeAdjustment, _that.getStrikeAdjustment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (strikeAdjustment != null ? strikeAdjustment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxAverageStrikeBuilder {" +
				"strikeAdjustment=" + this.strikeAdjustment +
			'}' + " " + super.toString();
		}
	}
}
