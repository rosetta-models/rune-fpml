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
import fpml.confirmation.FxAverageRate;
import fpml.confirmation.FxAverageRate.FxAverageRateBuilder;
import fpml.confirmation.FxAverageRate.FxAverageRateBuilderImpl;
import fpml.confirmation.FxAverageRate.FxAverageRateImpl;
import fpml.confirmation.FxAveragingMethodEnum;
import fpml.confirmation.FxAveragingProcess;
import fpml.confirmation.FxAveragingProcess.FxAveragingProcessBuilder;
import fpml.confirmation.FxAveragingProcess.FxAveragingProcessBuilderImpl;
import fpml.confirmation.FxAveragingProcess.FxAveragingProcessImpl;
import fpml.confirmation.FxCrossRateObservable;
import fpml.confirmation.FxInformationSource;
import fpml.confirmation.FxWeightedFixingSchedule;
import fpml.confirmation.QuotedCurrencyPair;
import fpml.confirmation.meta.FxAverageRateMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @version ${project.version}
 */
@RosettaDataType(value="FxAverageRate", builder=FxAverageRate.FxAverageRateBuilderImpl.class, version="${project.version}")
public interface FxAverageRate extends FxAveragingProcess {

	FxAverageRateMeta metaData = new FxAverageRateMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	FxAverageRate build();
	
	FxAverageRate.FxAverageRateBuilder toBuilder();
	
	static FxAverageRate.FxAverageRateBuilder builder() {
		return new FxAverageRate.FxAverageRateBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxAverageRate> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxAverageRate> getType() {
		return FxAverageRate.class;
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
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxAverageRateBuilder extends FxAverageRate, FxAveragingProcess.FxAveragingProcessBuilder {
		FxAverageRate.FxAverageRateBuilder setQuotedCurrencyPair(QuotedCurrencyPair quotedCurrencyPair);
		FxAverageRate.FxAverageRateBuilder setInformationSource(FxInformationSource informationSource);
		FxAverageRate.FxAverageRateBuilder addCrossRate(FxCrossRateObservable crossRate0);
		FxAverageRate.FxAverageRateBuilder addCrossRate(FxCrossRateObservable crossRate1, int _idx);
		FxAverageRate.FxAverageRateBuilder addCrossRate(List<? extends FxCrossRateObservable> crossRate2);
		FxAverageRate.FxAverageRateBuilder setCrossRate(List<? extends FxCrossRateObservable> crossRate3);
		FxAverageRate.FxAverageRateBuilder setId(String id);
		FxAverageRate.FxAverageRateBuilder setFixingSchedule(FxWeightedFixingSchedule fixingSchedule);
		FxAverageRate.FxAverageRateBuilder setAveragingMethod(FxAveragingMethodEnum averagingMethod);
		FxAverageRate.FxAverageRateBuilder setPrecision(Integer precision);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("quotedCurrencyPair"), processor, QuotedCurrencyPair.QuotedCurrencyPairBuilder.class, getQuotedCurrencyPair());
			processRosetta(path.newSubPath("informationSource"), processor, FxInformationSource.FxInformationSourceBuilder.class, getInformationSource());
			processRosetta(path.newSubPath("crossRate"), processor, FxCrossRateObservable.FxCrossRateObservableBuilder.class, getCrossRate());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("fixingSchedule"), processor, FxWeightedFixingSchedule.FxWeightedFixingScheduleBuilder.class, getFixingSchedule());
			processor.processBasic(path.newSubPath("averagingMethod"), FxAveragingMethodEnum.class, getAveragingMethod(), this);
			processor.processBasic(path.newSubPath("precision"), Integer.class, getPrecision(), this);
		}
		

		FxAverageRate.FxAverageRateBuilder prune();
	}

	/*********************** Immutable Implementation of FxAverageRate  ***********************/
	class FxAverageRateImpl extends FxAveragingProcess.FxAveragingProcessImpl implements FxAverageRate {
		
		protected FxAverageRateImpl(FxAverageRate.FxAverageRateBuilder builder) {
			super(builder);
		}
		
		@Override
		public FxAverageRate build() {
			return this;
		}
		
		@Override
		public FxAverageRate.FxAverageRateBuilder toBuilder() {
			FxAverageRate.FxAverageRateBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxAverageRate.FxAverageRateBuilder builder) {
			super.setBuilderFields(builder);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxAverageRate {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxAverageRate  ***********************/
	class FxAverageRateBuilderImpl extends FxAveragingProcess.FxAveragingProcessBuilderImpl  implements FxAverageRate.FxAverageRateBuilder {
	
	
		public FxAverageRateBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("quotedCurrencyPair")
		public FxAverageRate.FxAverageRateBuilder setQuotedCurrencyPair(QuotedCurrencyPair quotedCurrencyPair) {
			this.quotedCurrencyPair = quotedCurrencyPair==null?null:quotedCurrencyPair.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("informationSource")
		public FxAverageRate.FxAverageRateBuilder setInformationSource(FxInformationSource informationSource) {
			this.informationSource = informationSource==null?null:informationSource.toBuilder();
			return this;
		}
		@Override
		public FxAverageRate.FxAverageRateBuilder addCrossRate(FxCrossRateObservable crossRate) {
			if (crossRate!=null) this.crossRate.add(crossRate.toBuilder());
			return this;
		}
		
		@Override
		public FxAverageRate.FxAverageRateBuilder addCrossRate(FxCrossRateObservable crossRate, int _idx) {
			getIndex(this.crossRate, _idx, () -> crossRate.toBuilder());
			return this;
		}
		@Override 
		public FxAverageRate.FxAverageRateBuilder addCrossRate(List<? extends FxCrossRateObservable> crossRates) {
			if (crossRates != null) {
				for (FxCrossRateObservable toAdd : crossRates) {
					this.crossRate.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("crossRate")
		public FxAverageRate.FxAverageRateBuilder setCrossRate(List<? extends FxCrossRateObservable> crossRates) {
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
		public FxAverageRate.FxAverageRateBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("fixingSchedule")
		public FxAverageRate.FxAverageRateBuilder setFixingSchedule(FxWeightedFixingSchedule fixingSchedule) {
			this.fixingSchedule = fixingSchedule==null?null:fixingSchedule.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("averagingMethod")
		public FxAverageRate.FxAverageRateBuilder setAveragingMethod(FxAveragingMethodEnum averagingMethod) {
			this.averagingMethod = averagingMethod==null?null:averagingMethod;
			return this;
		}
		@Override
		@RosettaAttribute("precision")
		public FxAverageRate.FxAverageRateBuilder setPrecision(Integer precision) {
			this.precision = precision==null?null:precision;
			return this;
		}
		
		@Override
		public FxAverageRate build() {
			return new FxAverageRate.FxAverageRateImpl(this);
		}
		
		@Override
		public FxAverageRate.FxAverageRateBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAverageRate.FxAverageRateBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAverageRate.FxAverageRateBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FxAverageRate.FxAverageRateBuilder o = (FxAverageRate.FxAverageRateBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxAverageRateBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
