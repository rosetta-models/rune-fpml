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
import fpml.confirmation.FloatingRateIndexModel;
import fpml.confirmation.FloatingRateIndexModel.FloatingRateIndexModelBuilder;
import fpml.confirmation.FloatingRateIndexModel.FloatingRateIndexModelBuilderImpl;
import fpml.confirmation.FloatingRateIndexModel.FloatingRateIndexModelImpl;
import fpml.confirmation.Period;
import fpml.confirmation.meta.FloatingRateIndexModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="FloatingRateIndexModel", builder=FloatingRateIndexModel.FloatingRateIndexModelBuilderImpl.class, version="${project.version}")
public interface FloatingRateIndexModel extends RosettaModelObject {

	FloatingRateIndexModelMeta metaData = new FloatingRateIndexModelMeta();

	/*********************** Getter Methods  ***********************/
	FloatingRateIndex getFloatingRateIndex();
	/**
	 * The ISDA Designated Maturity, i.e. the tenor of the floating rate.
	 */
	Period getIndexTenor();

	/*********************** Build Methods  ***********************/
	FloatingRateIndexModel build();
	
	FloatingRateIndexModel.FloatingRateIndexModelBuilder toBuilder();
	
	static FloatingRateIndexModel.FloatingRateIndexModelBuilder builder() {
		return new FloatingRateIndexModel.FloatingRateIndexModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FloatingRateIndexModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FloatingRateIndexModel> getType() {
		return FloatingRateIndexModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("floatingRateIndex"), processor, FloatingRateIndex.class, getFloatingRateIndex());
		processRosetta(path.newSubPath("indexTenor"), processor, Period.class, getIndexTenor());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FloatingRateIndexModelBuilder extends FloatingRateIndexModel, RosettaModelObjectBuilder {
		FloatingRateIndex.FloatingRateIndexBuilder getOrCreateFloatingRateIndex();
		FloatingRateIndex.FloatingRateIndexBuilder getFloatingRateIndex();
		Period.PeriodBuilder getOrCreateIndexTenor();
		Period.PeriodBuilder getIndexTenor();
		FloatingRateIndexModel.FloatingRateIndexModelBuilder setFloatingRateIndex(FloatingRateIndex floatingRateIndex);
		FloatingRateIndexModel.FloatingRateIndexModelBuilder setIndexTenor(Period indexTenor);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("floatingRateIndex"), processor, FloatingRateIndex.FloatingRateIndexBuilder.class, getFloatingRateIndex());
			processRosetta(path.newSubPath("indexTenor"), processor, Period.PeriodBuilder.class, getIndexTenor());
		}
		

		FloatingRateIndexModel.FloatingRateIndexModelBuilder prune();
	}

	/*********************** Immutable Implementation of FloatingRateIndexModel  ***********************/
	class FloatingRateIndexModelImpl implements FloatingRateIndexModel {
		private final FloatingRateIndex floatingRateIndex;
		private final Period indexTenor;
		
		protected FloatingRateIndexModelImpl(FloatingRateIndexModel.FloatingRateIndexModelBuilder builder) {
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
		public FloatingRateIndexModel build() {
			return this;
		}
		
		@Override
		public FloatingRateIndexModel.FloatingRateIndexModelBuilder toBuilder() {
			FloatingRateIndexModel.FloatingRateIndexModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FloatingRateIndexModel.FloatingRateIndexModelBuilder builder) {
			ofNullable(getFloatingRateIndex()).ifPresent(builder::setFloatingRateIndex);
			ofNullable(getIndexTenor()).ifPresent(builder::setIndexTenor);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FloatingRateIndexModel _that = getType().cast(o);
		
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
			return "FloatingRateIndexModel {" +
				"floatingRateIndex=" + this.floatingRateIndex + ", " +
				"indexTenor=" + this.indexTenor +
			'}';
		}
	}

	/*********************** Builder Implementation of FloatingRateIndexModel  ***********************/
	class FloatingRateIndexModelBuilderImpl implements FloatingRateIndexModel.FloatingRateIndexModelBuilder {
	
		protected FloatingRateIndex.FloatingRateIndexBuilder floatingRateIndex;
		protected Period.PeriodBuilder indexTenor;
	
		public FloatingRateIndexModelBuilderImpl() {
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
		public FloatingRateIndexModel.FloatingRateIndexModelBuilder setFloatingRateIndex(FloatingRateIndex floatingRateIndex) {
			this.floatingRateIndex = floatingRateIndex==null?null:floatingRateIndex.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("indexTenor")
		public FloatingRateIndexModel.FloatingRateIndexModelBuilder setIndexTenor(Period indexTenor) {
			this.indexTenor = indexTenor==null?null:indexTenor.toBuilder();
			return this;
		}
		
		@Override
		public FloatingRateIndexModel build() {
			return new FloatingRateIndexModel.FloatingRateIndexModelImpl(this);
		}
		
		@Override
		public FloatingRateIndexModel.FloatingRateIndexModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FloatingRateIndexModel.FloatingRateIndexModelBuilder prune() {
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
		public FloatingRateIndexModel.FloatingRateIndexModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FloatingRateIndexModel.FloatingRateIndexModelBuilder o = (FloatingRateIndexModel.FloatingRateIndexModelBuilder) other;
			
			merger.mergeRosetta(getFloatingRateIndex(), o.getFloatingRateIndex(), this::setFloatingRateIndex);
			merger.mergeRosetta(getIndexTenor(), o.getIndexTenor(), this::setIndexTenor);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FloatingRateIndexModel _that = getType().cast(o);
		
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
			return "FloatingRateIndexModelBuilder {" +
				"floatingRateIndex=" + this.floatingRateIndex + ", " +
				"indexTenor=" + this.indexTenor +
			'}';
		}
	}
}
