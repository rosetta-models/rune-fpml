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
import fpml.confirmation.FloatingRateIndex;
import fpml.confirmation.ForecastRateIndex;
import fpml.confirmation.ForecastRateIndex.ForecastRateIndexBuilder;
import fpml.confirmation.ForecastRateIndex.ForecastRateIndexBuilderImpl;
import fpml.confirmation.ForecastRateIndex.ForecastRateIndexImpl;
import fpml.confirmation.Period;
import fpml.confirmation.meta.ForecastRateIndexMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type defining a rate index.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="ForecastRateIndex", builder=ForecastRateIndex.ForecastRateIndexBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface ForecastRateIndex extends RosettaModelObject {

	ForecastRateIndexMeta metaData = new ForecastRateIndexMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The ISDA Floating Rate Option, i.e. the floating rate index.
	 */
	FloatingRateIndex getFloatingRateIndex();
	/**
	 * The ISDA Designated Maturity, i.e. the tenor of the floating rate.
	 */
	Period getIndexTenor();

	/*********************** Build Methods  ***********************/
	ForecastRateIndex build();
	
	ForecastRateIndex.ForecastRateIndexBuilder toBuilder();
	
	static ForecastRateIndex.ForecastRateIndexBuilder builder() {
		return new ForecastRateIndex.ForecastRateIndexBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ForecastRateIndex> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ForecastRateIndex> getType() {
		return ForecastRateIndex.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("floatingRateIndex"), processor, FloatingRateIndex.class, getFloatingRateIndex());
		processRosetta(path.newSubPath("indexTenor"), processor, Period.class, getIndexTenor());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ForecastRateIndexBuilder extends ForecastRateIndex, RosettaModelObjectBuilder {
		FloatingRateIndex.FloatingRateIndexBuilder getOrCreateFloatingRateIndex();
		FloatingRateIndex.FloatingRateIndexBuilder getFloatingRateIndex();
		Period.PeriodBuilder getOrCreateIndexTenor();
		Period.PeriodBuilder getIndexTenor();
		ForecastRateIndex.ForecastRateIndexBuilder setFloatingRateIndex(FloatingRateIndex floatingRateIndex);
		ForecastRateIndex.ForecastRateIndexBuilder setIndexTenor(Period indexTenor);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("floatingRateIndex"), processor, FloatingRateIndex.FloatingRateIndexBuilder.class, getFloatingRateIndex());
			processRosetta(path.newSubPath("indexTenor"), processor, Period.PeriodBuilder.class, getIndexTenor());
		}
		

		ForecastRateIndex.ForecastRateIndexBuilder prune();
	}

	/*********************** Immutable Implementation of ForecastRateIndex  ***********************/
	class ForecastRateIndexImpl implements ForecastRateIndex {
		private final FloatingRateIndex floatingRateIndex;
		private final Period indexTenor;
		
		protected ForecastRateIndexImpl(ForecastRateIndex.ForecastRateIndexBuilder builder) {
			this.floatingRateIndex = ofNullable(builder.getFloatingRateIndex()).map(f->f.build()).orElse(null);
			this.indexTenor = ofNullable(builder.getIndexTenor()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("floatingRateIndex")
		public FloatingRateIndex getFloatingRateIndex() {
			return floatingRateIndex;
		}
		
		@Override
		@RosettaAttribute("indexTenor")
		public Period getIndexTenor() {
			return indexTenor;
		}
		
		@Override
		public ForecastRateIndex build() {
			return this;
		}
		
		@Override
		public ForecastRateIndex.ForecastRateIndexBuilder toBuilder() {
			ForecastRateIndex.ForecastRateIndexBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ForecastRateIndex.ForecastRateIndexBuilder builder) {
			ofNullable(getFloatingRateIndex()).ifPresent(builder::setFloatingRateIndex);
			ofNullable(getIndexTenor()).ifPresent(builder::setIndexTenor);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ForecastRateIndex _that = getType().cast(o);
		
			if (!Objects.equals(floatingRateIndex, _that.getFloatingRateIndex())) return false;
			if (!Objects.equals(indexTenor, _that.getIndexTenor())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (floatingRateIndex != null ? floatingRateIndex.hashCode() : 0);
			_result = 31 * _result + (indexTenor != null ? indexTenor.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ForecastRateIndex {" +
				"floatingRateIndex=" + this.floatingRateIndex + ", " +
				"indexTenor=" + this.indexTenor +
			'}';
		}
	}

	/*********************** Builder Implementation of ForecastRateIndex  ***********************/
	class ForecastRateIndexBuilderImpl implements ForecastRateIndex.ForecastRateIndexBuilder {
	
		protected FloatingRateIndex.FloatingRateIndexBuilder floatingRateIndex;
		protected Period.PeriodBuilder indexTenor;
	
		public ForecastRateIndexBuilderImpl() {
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
		@RosettaAttribute("indexTenor")
		public Period.PeriodBuilder getIndexTenor() {
			return indexTenor;
		}
		
		@Override
		public Period.PeriodBuilder getOrCreateIndexTenor() {
			Period.PeriodBuilder result;
			if (indexTenor!=null) {
				result = indexTenor;
			}
			else {
				result = indexTenor = Period.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("floatingRateIndex")
		public ForecastRateIndex.ForecastRateIndexBuilder setFloatingRateIndex(FloatingRateIndex floatingRateIndex) {
			this.floatingRateIndex = floatingRateIndex==null?null:floatingRateIndex.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("indexTenor")
		public ForecastRateIndex.ForecastRateIndexBuilder setIndexTenor(Period indexTenor) {
			this.indexTenor = indexTenor==null?null:indexTenor.toBuilder();
			return this;
		}
		
		@Override
		public ForecastRateIndex build() {
			return new ForecastRateIndex.ForecastRateIndexImpl(this);
		}
		
		@Override
		public ForecastRateIndex.ForecastRateIndexBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ForecastRateIndex.ForecastRateIndexBuilder prune() {
			if (floatingRateIndex!=null && !floatingRateIndex.prune().hasData()) floatingRateIndex = null;
			if (indexTenor!=null && !indexTenor.prune().hasData()) indexTenor = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFloatingRateIndex()!=null && getFloatingRateIndex().hasData()) return true;
			if (getIndexTenor()!=null && getIndexTenor().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ForecastRateIndex.ForecastRateIndexBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ForecastRateIndex.ForecastRateIndexBuilder o = (ForecastRateIndex.ForecastRateIndexBuilder) other;
			
			merger.mergeRosetta(getFloatingRateIndex(), o.getFloatingRateIndex(), this::setFloatingRateIndex);
			merger.mergeRosetta(getIndexTenor(), o.getIndexTenor(), this::setIndexTenor);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ForecastRateIndex _that = getType().cast(o);
		
			if (!Objects.equals(floatingRateIndex, _that.getFloatingRateIndex())) return false;
			if (!Objects.equals(indexTenor, _that.getIndexTenor())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (floatingRateIndex != null ? floatingRateIndex.hashCode() : 0);
			_result = 31 * _result + (indexTenor != null ? indexTenor.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ForecastRateIndexBuilder {" +
				"floatingRateIndex=" + this.floatingRateIndex + ", " +
				"indexTenor=" + this.indexTenor +
			'}';
		}
	}
}
