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
import fpml.confirmation.ForecastRateIndex;
import fpml.confirmation.YieldCurveCharacteristicsModel;
import fpml.confirmation.YieldCurveCharacteristicsModel.YieldCurveCharacteristicsModelBuilder;
import fpml.confirmation.YieldCurveCharacteristicsModel.YieldCurveCharacteristicsModelBuilderImpl;
import fpml.confirmation.YieldCurveCharacteristicsModel.YieldCurveCharacteristicsModelImpl;
import fpml.confirmation.meta.YieldCurveCharacteristicsModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The set of characteristics that describe the outputs of a yield curve.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="YieldCurveCharacteristicsModel", builder=YieldCurveCharacteristicsModel.YieldCurveCharacteristicsModelBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface YieldCurveCharacteristicsModel extends RosettaModelObject {

	YieldCurveCharacteristicsModelMeta metaData = new YieldCurveCharacteristicsModelMeta();

	/*********************** Getter Methods  ***********************/
	String getAlgorithm();
	ForecastRateIndex getForecastRateIndex();

	/*********************** Build Methods  ***********************/
	YieldCurveCharacteristicsModel build();
	
	YieldCurveCharacteristicsModel.YieldCurveCharacteristicsModelBuilder toBuilder();
	
	static YieldCurveCharacteristicsModel.YieldCurveCharacteristicsModelBuilder builder() {
		return new YieldCurveCharacteristicsModel.YieldCurveCharacteristicsModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends YieldCurveCharacteristicsModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends YieldCurveCharacteristicsModel> getType() {
		return YieldCurveCharacteristicsModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("algorithm"), String.class, getAlgorithm(), this);
		processRosetta(path.newSubPath("forecastRateIndex"), processor, ForecastRateIndex.class, getForecastRateIndex());
	}
	

	/*********************** Builder Interface  ***********************/
	interface YieldCurveCharacteristicsModelBuilder extends YieldCurveCharacteristicsModel, RosettaModelObjectBuilder {
		ForecastRateIndex.ForecastRateIndexBuilder getOrCreateForecastRateIndex();
		ForecastRateIndex.ForecastRateIndexBuilder getForecastRateIndex();
		YieldCurveCharacteristicsModel.YieldCurveCharacteristicsModelBuilder setAlgorithm(String algorithm);
		YieldCurveCharacteristicsModel.YieldCurveCharacteristicsModelBuilder setForecastRateIndex(ForecastRateIndex forecastRateIndex);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("algorithm"), String.class, getAlgorithm(), this);
			processRosetta(path.newSubPath("forecastRateIndex"), processor, ForecastRateIndex.ForecastRateIndexBuilder.class, getForecastRateIndex());
		}
		

		YieldCurveCharacteristicsModel.YieldCurveCharacteristicsModelBuilder prune();
	}

	/*********************** Immutable Implementation of YieldCurveCharacteristicsModel  ***********************/
	class YieldCurveCharacteristicsModelImpl implements YieldCurveCharacteristicsModel {
		private final String algorithm;
		private final ForecastRateIndex forecastRateIndex;
		
		protected YieldCurveCharacteristicsModelImpl(YieldCurveCharacteristicsModel.YieldCurveCharacteristicsModelBuilder builder) {
			this.algorithm = builder.getAlgorithm();
			this.forecastRateIndex = ofNullable(builder.getForecastRateIndex()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("algorithm")
		public String getAlgorithm() {
			return algorithm;
		}
		
		@Override
		@RosettaAttribute("forecastRateIndex")
		public ForecastRateIndex getForecastRateIndex() {
			return forecastRateIndex;
		}
		
		@Override
		public YieldCurveCharacteristicsModel build() {
			return this;
		}
		
		@Override
		public YieldCurveCharacteristicsModel.YieldCurveCharacteristicsModelBuilder toBuilder() {
			YieldCurveCharacteristicsModel.YieldCurveCharacteristicsModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(YieldCurveCharacteristicsModel.YieldCurveCharacteristicsModelBuilder builder) {
			ofNullable(getAlgorithm()).ifPresent(builder::setAlgorithm);
			ofNullable(getForecastRateIndex()).ifPresent(builder::setForecastRateIndex);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			YieldCurveCharacteristicsModel _that = getType().cast(o);
		
			if (!Objects.equals(algorithm, _that.getAlgorithm())) return false;
			if (!Objects.equals(forecastRateIndex, _that.getForecastRateIndex())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (algorithm != null ? algorithm.hashCode() : 0);
			_result = 31 * _result + (forecastRateIndex != null ? forecastRateIndex.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "YieldCurveCharacteristicsModel {" +
				"algorithm=" + this.algorithm + ", " +
				"forecastRateIndex=" + this.forecastRateIndex +
			'}';
		}
	}

	/*********************** Builder Implementation of YieldCurveCharacteristicsModel  ***********************/
	class YieldCurveCharacteristicsModelBuilderImpl implements YieldCurveCharacteristicsModel.YieldCurveCharacteristicsModelBuilder {
	
		protected String algorithm;
		protected ForecastRateIndex.ForecastRateIndexBuilder forecastRateIndex;
	
		public YieldCurveCharacteristicsModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("algorithm")
		public String getAlgorithm() {
			return algorithm;
		}
		
		@Override
		@RosettaAttribute("forecastRateIndex")
		public ForecastRateIndex.ForecastRateIndexBuilder getForecastRateIndex() {
			return forecastRateIndex;
		}
		
		@Override
		public ForecastRateIndex.ForecastRateIndexBuilder getOrCreateForecastRateIndex() {
			ForecastRateIndex.ForecastRateIndexBuilder result;
			if (forecastRateIndex!=null) {
				result = forecastRateIndex;
			}
			else {
				result = forecastRateIndex = ForecastRateIndex.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("algorithm")
		public YieldCurveCharacteristicsModel.YieldCurveCharacteristicsModelBuilder setAlgorithm(String algorithm) {
			this.algorithm = algorithm==null?null:algorithm;
			return this;
		}
		@Override
		@RosettaAttribute("forecastRateIndex")
		public YieldCurveCharacteristicsModel.YieldCurveCharacteristicsModelBuilder setForecastRateIndex(ForecastRateIndex forecastRateIndex) {
			this.forecastRateIndex = forecastRateIndex==null?null:forecastRateIndex.toBuilder();
			return this;
		}
		
		@Override
		public YieldCurveCharacteristicsModel build() {
			return new YieldCurveCharacteristicsModel.YieldCurveCharacteristicsModelImpl(this);
		}
		
		@Override
		public YieldCurveCharacteristicsModel.YieldCurveCharacteristicsModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public YieldCurveCharacteristicsModel.YieldCurveCharacteristicsModelBuilder prune() {
			if (forecastRateIndex!=null && !forecastRateIndex.prune().hasData()) forecastRateIndex = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAlgorithm()!=null) return true;
			if (getForecastRateIndex()!=null && getForecastRateIndex().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public YieldCurveCharacteristicsModel.YieldCurveCharacteristicsModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			YieldCurveCharacteristicsModel.YieldCurveCharacteristicsModelBuilder o = (YieldCurveCharacteristicsModel.YieldCurveCharacteristicsModelBuilder) other;
			
			merger.mergeRosetta(getForecastRateIndex(), o.getForecastRateIndex(), this::setForecastRateIndex);
			
			merger.mergeBasic(getAlgorithm(), o.getAlgorithm(), this::setAlgorithm);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			YieldCurveCharacteristicsModel _that = getType().cast(o);
		
			if (!Objects.equals(algorithm, _that.getAlgorithm())) return false;
			if (!Objects.equals(forecastRateIndex, _that.getForecastRateIndex())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (algorithm != null ? algorithm.hashCode() : 0);
			_result = 31 * _result + (forecastRateIndex != null ? forecastRateIndex.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "YieldCurveCharacteristicsModelBuilder {" +
				"algorithm=" + this.algorithm + ", " +
				"forecastRateIndex=" + this.forecastRateIndex +
			'}';
		}
	}
}
