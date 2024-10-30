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
import fpml.confirmation.Period;
import fpml.confirmation.StubFloatingRateIndexModel;
import fpml.confirmation.StubFloatingRateIndexModel.StubFloatingRateIndexModelBuilder;
import fpml.confirmation.StubFloatingRateIndexModel.StubFloatingRateIndexModelBuilderImpl;
import fpml.confirmation.StubFloatingRateIndexModel.StubFloatingRateIndexModelImpl;
import fpml.confirmation.meta.StubFloatingRateIndexModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="StubFloatingRateIndexModel", builder=StubFloatingRateIndexModel.StubFloatingRateIndexModelBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface StubFloatingRateIndexModel extends RosettaModelObject {

	StubFloatingRateIndexModelMeta metaData = new StubFloatingRateIndexModelMeta();

	/*********************** Getter Methods  ***********************/
	FloatingRateIndex getFloatingRateIndex();
	/**
	 * The ISDA Designated Maturity, i.e. the tenor of the floating rate.
	 */
	Period getIndexTenor();

	/*********************** Build Methods  ***********************/
	StubFloatingRateIndexModel build();
	
	StubFloatingRateIndexModel.StubFloatingRateIndexModelBuilder toBuilder();
	
	static StubFloatingRateIndexModel.StubFloatingRateIndexModelBuilder builder() {
		return new StubFloatingRateIndexModel.StubFloatingRateIndexModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends StubFloatingRateIndexModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends StubFloatingRateIndexModel> getType() {
		return StubFloatingRateIndexModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("floatingRateIndex"), processor, FloatingRateIndex.class, getFloatingRateIndex());
		processRosetta(path.newSubPath("indexTenor"), processor, Period.class, getIndexTenor());
	}
	

	/*********************** Builder Interface  ***********************/
	interface StubFloatingRateIndexModelBuilder extends StubFloatingRateIndexModel, RosettaModelObjectBuilder {
		FloatingRateIndex.FloatingRateIndexBuilder getOrCreateFloatingRateIndex();
		FloatingRateIndex.FloatingRateIndexBuilder getFloatingRateIndex();
		Period.PeriodBuilder getOrCreateIndexTenor();
		Period.PeriodBuilder getIndexTenor();
		StubFloatingRateIndexModel.StubFloatingRateIndexModelBuilder setFloatingRateIndex(FloatingRateIndex floatingRateIndex);
		StubFloatingRateIndexModel.StubFloatingRateIndexModelBuilder setIndexTenor(Period indexTenor);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("floatingRateIndex"), processor, FloatingRateIndex.FloatingRateIndexBuilder.class, getFloatingRateIndex());
			processRosetta(path.newSubPath("indexTenor"), processor, Period.PeriodBuilder.class, getIndexTenor());
		}
		

		StubFloatingRateIndexModel.StubFloatingRateIndexModelBuilder prune();
	}

	/*********************** Immutable Implementation of StubFloatingRateIndexModel  ***********************/
	class StubFloatingRateIndexModelImpl implements StubFloatingRateIndexModel {
		private final FloatingRateIndex floatingRateIndex;
		private final Period indexTenor;
		
		protected StubFloatingRateIndexModelImpl(StubFloatingRateIndexModel.StubFloatingRateIndexModelBuilder builder) {
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
		public StubFloatingRateIndexModel build() {
			return this;
		}
		
		@Override
		public StubFloatingRateIndexModel.StubFloatingRateIndexModelBuilder toBuilder() {
			StubFloatingRateIndexModel.StubFloatingRateIndexModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(StubFloatingRateIndexModel.StubFloatingRateIndexModelBuilder builder) {
			ofNullable(getFloatingRateIndex()).ifPresent(builder::setFloatingRateIndex);
			ofNullable(getIndexTenor()).ifPresent(builder::setIndexTenor);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			StubFloatingRateIndexModel _that = getType().cast(o);
		
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
			return "StubFloatingRateIndexModel {" +
				"floatingRateIndex=" + this.floatingRateIndex + ", " +
				"indexTenor=" + this.indexTenor +
			'}';
		}
	}

	/*********************** Builder Implementation of StubFloatingRateIndexModel  ***********************/
	class StubFloatingRateIndexModelBuilderImpl implements StubFloatingRateIndexModel.StubFloatingRateIndexModelBuilder {
	
		protected FloatingRateIndex.FloatingRateIndexBuilder floatingRateIndex;
		protected Period.PeriodBuilder indexTenor;
	
		public StubFloatingRateIndexModelBuilderImpl() {
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
		public StubFloatingRateIndexModel.StubFloatingRateIndexModelBuilder setFloatingRateIndex(FloatingRateIndex floatingRateIndex) {
			this.floatingRateIndex = floatingRateIndex==null?null:floatingRateIndex.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("indexTenor")
		public StubFloatingRateIndexModel.StubFloatingRateIndexModelBuilder setIndexTenor(Period indexTenor) {
			this.indexTenor = indexTenor==null?null:indexTenor.toBuilder();
			return this;
		}
		
		@Override
		public StubFloatingRateIndexModel build() {
			return new StubFloatingRateIndexModel.StubFloatingRateIndexModelImpl(this);
		}
		
		@Override
		public StubFloatingRateIndexModel.StubFloatingRateIndexModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public StubFloatingRateIndexModel.StubFloatingRateIndexModelBuilder prune() {
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
		public StubFloatingRateIndexModel.StubFloatingRateIndexModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			StubFloatingRateIndexModel.StubFloatingRateIndexModelBuilder o = (StubFloatingRateIndexModel.StubFloatingRateIndexModelBuilder) other;
			
			merger.mergeRosetta(getFloatingRateIndex(), o.getFloatingRateIndex(), this::setFloatingRateIndex);
			merger.mergeRosetta(getIndexTenor(), o.getIndexTenor(), this::setIndexTenor);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			StubFloatingRateIndexModel _that = getType().cast(o);
		
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
			return "StubFloatingRateIndexModelBuilder {" +
				"floatingRateIndex=" + this.floatingRateIndex + ", " +
				"indexTenor=" + this.indexTenor +
			'}';
		}
	}
}
