package cdm.observable.asset;

import cdm.observable.asset.FloatingRateIndex;
import cdm.observable.asset.FloatingRateIndex.FloatingRateIndexBuilder;
import cdm.observable.asset.FloatingRateIndex.FloatingRateIndexBuilderImpl;
import cdm.observable.asset.FloatingRateIndex.FloatingRateIndexImpl;
import cdm.observable.asset.InflationIndex;
import cdm.observable.asset.InterestRateIndex;
import cdm.observable.asset.meta.FloatingRateIndexMeta;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * An index based in interest rates or inflation rates in a certain market.
 * @version 6.0.0-dev.76
 */
@RosettaDataType(value="FloatingRateIndex", builder=FloatingRateIndex.FloatingRateIndexBuilderImpl.class, version="6.0.0-dev.76")
public interface FloatingRateIndex extends RosettaModelObject {

	FloatingRateIndexMeta metaData = new FloatingRateIndexMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * An interest rate index which can change over time, e.g. the SONIA (Sterling Overnight Index Average) in the UK.
	 */
	InterestRateIndex getInterestRateIndex();
	/**
	 * An index that measures inflation in a specific market, e.g. the US Consumer Price Index.
	 */
	InflationIndex getInflationIndex();

	/*********************** Build Methods  ***********************/
	FloatingRateIndex build();
	
	FloatingRateIndex.FloatingRateIndexBuilder toBuilder();
	
	static FloatingRateIndex.FloatingRateIndexBuilder builder() {
		return new FloatingRateIndex.FloatingRateIndexBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FloatingRateIndex> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FloatingRateIndex> getType() {
		return FloatingRateIndex.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("InterestRateIndex"), processor, InterestRateIndex.class, getInterestRateIndex());
		processRosetta(path.newSubPath("InflationIndex"), processor, InflationIndex.class, getInflationIndex());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FloatingRateIndexBuilder extends FloatingRateIndex, RosettaModelObjectBuilder {
		InterestRateIndex.InterestRateIndexBuilder getOrCreateInterestRateIndex();
		InterestRateIndex.InterestRateIndexBuilder getInterestRateIndex();
		InflationIndex.InflationIndexBuilder getOrCreateInflationIndex();
		InflationIndex.InflationIndexBuilder getInflationIndex();
		FloatingRateIndex.FloatingRateIndexBuilder setInterestRateIndex(InterestRateIndex _InterestRateIndex);
		FloatingRateIndex.FloatingRateIndexBuilder setInflationIndex(InflationIndex _InflationIndex);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("InterestRateIndex"), processor, InterestRateIndex.InterestRateIndexBuilder.class, getInterestRateIndex());
			processRosetta(path.newSubPath("InflationIndex"), processor, InflationIndex.InflationIndexBuilder.class, getInflationIndex());
		}
		

		FloatingRateIndex.FloatingRateIndexBuilder prune();
	}

	/*********************** Immutable Implementation of FloatingRateIndex  ***********************/
	class FloatingRateIndexImpl implements FloatingRateIndex {
		private final InterestRateIndex interestRateIndex;
		private final InflationIndex inflationIndex;
		
		protected FloatingRateIndexImpl(FloatingRateIndex.FloatingRateIndexBuilder builder) {
			this.interestRateIndex = ofNullable(builder.getInterestRateIndex()).map(f->f.build()).orElse(null);
			this.inflationIndex = ofNullable(builder.getInflationIndex()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("InterestRateIndex")
		public InterestRateIndex getInterestRateIndex() {
			return interestRateIndex;
		}
		
		@Override
		@RosettaAttribute("InflationIndex")
		public InflationIndex getInflationIndex() {
			return inflationIndex;
		}
		
		@Override
		public FloatingRateIndex build() {
			return this;
		}
		
		@Override
		public FloatingRateIndex.FloatingRateIndexBuilder toBuilder() {
			FloatingRateIndex.FloatingRateIndexBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FloatingRateIndex.FloatingRateIndexBuilder builder) {
			ofNullable(getInterestRateIndex()).ifPresent(builder::setInterestRateIndex);
			ofNullable(getInflationIndex()).ifPresent(builder::setInflationIndex);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FloatingRateIndex _that = getType().cast(o);
		
			if (!Objects.equals(interestRateIndex, _that.getInterestRateIndex())) return false;
			if (!Objects.equals(inflationIndex, _that.getInflationIndex())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (interestRateIndex != null ? interestRateIndex.hashCode() : 0);
			_result = 31 * _result + (inflationIndex != null ? inflationIndex.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FloatingRateIndex {" +
				"InterestRateIndex=" + this.interestRateIndex + ", " +
				"InflationIndex=" + this.inflationIndex +
			'}';
		}
	}

	/*********************** Builder Implementation of FloatingRateIndex  ***********************/
	class FloatingRateIndexBuilderImpl implements FloatingRateIndex.FloatingRateIndexBuilder {
	
		protected InterestRateIndex.InterestRateIndexBuilder interestRateIndex;
		protected InflationIndex.InflationIndexBuilder inflationIndex;
	
		public FloatingRateIndexBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("InterestRateIndex")
		public InterestRateIndex.InterestRateIndexBuilder getInterestRateIndex() {
			return interestRateIndex;
		}
		
		@Override
		public InterestRateIndex.InterestRateIndexBuilder getOrCreateInterestRateIndex() {
			InterestRateIndex.InterestRateIndexBuilder result;
			if (interestRateIndex!=null) {
				result = interestRateIndex;
			}
			else {
				result = interestRateIndex = InterestRateIndex.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("InflationIndex")
		public InflationIndex.InflationIndexBuilder getInflationIndex() {
			return inflationIndex;
		}
		
		@Override
		public InflationIndex.InflationIndexBuilder getOrCreateInflationIndex() {
			InflationIndex.InflationIndexBuilder result;
			if (inflationIndex!=null) {
				result = inflationIndex;
			}
			else {
				result = inflationIndex = InflationIndex.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("InterestRateIndex")
		public FloatingRateIndex.FloatingRateIndexBuilder setInterestRateIndex(InterestRateIndex interestRateIndex) {
			this.interestRateIndex = interestRateIndex==null?null:interestRateIndex.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("InflationIndex")
		public FloatingRateIndex.FloatingRateIndexBuilder setInflationIndex(InflationIndex inflationIndex) {
			this.inflationIndex = inflationIndex==null?null:inflationIndex.toBuilder();
			return this;
		}
		
		@Override
		public FloatingRateIndex build() {
			return new FloatingRateIndex.FloatingRateIndexImpl(this);
		}
		
		@Override
		public FloatingRateIndex.FloatingRateIndexBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FloatingRateIndex.FloatingRateIndexBuilder prune() {
			if (interestRateIndex!=null && !interestRateIndex.prune().hasData()) interestRateIndex = null;
			if (inflationIndex!=null && !inflationIndex.prune().hasData()) inflationIndex = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getInterestRateIndex()!=null && getInterestRateIndex().hasData()) return true;
			if (getInflationIndex()!=null && getInflationIndex().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FloatingRateIndex.FloatingRateIndexBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FloatingRateIndex.FloatingRateIndexBuilder o = (FloatingRateIndex.FloatingRateIndexBuilder) other;
			
			merger.mergeRosetta(getInterestRateIndex(), o.getInterestRateIndex(), this::setInterestRateIndex);
			merger.mergeRosetta(getInflationIndex(), o.getInflationIndex(), this::setInflationIndex);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FloatingRateIndex _that = getType().cast(o);
		
			if (!Objects.equals(interestRateIndex, _that.getInterestRateIndex())) return false;
			if (!Objects.equals(inflationIndex, _that.getInflationIndex())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (interestRateIndex != null ? interestRateIndex.hashCode() : 0);
			_result = 31 * _result + (inflationIndex != null ? inflationIndex.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FloatingRateIndexBuilder {" +
				"InterestRateIndex=" + this.interestRateIndex + ", " +
				"InflationIndex=" + this.inflationIndex +
			'}';
		}
	}
}
