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
import fpml.confirmation.FxAccrualPayoffRegion;
import fpml.confirmation.FxAccrualPayoffRegion.FxAccrualPayoffRegionBuilder;
import fpml.confirmation.FxAccrualPayoffRegion.FxAccrualPayoffRegionBuilderImpl;
import fpml.confirmation.FxAccrualPayoffRegion.FxAccrualPayoffRegionImpl;
import fpml.confirmation.meta.FxAccrualPayoffRegionMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="FxAccrualPayoffRegion", builder=FxAccrualPayoffRegion.FxAccrualPayoffRegionBuilderImpl.class, version="${project.version}")
public interface FxAccrualPayoffRegion extends RosettaModelObject {

	FxAccrualPayoffRegionMeta metaData = new FxAccrualPayoffRegionMeta();

	/*********************** Getter Methods  ***********************/
	String getId();

	/*********************** Build Methods  ***********************/
	FxAccrualPayoffRegion build();
	
	FxAccrualPayoffRegion.FxAccrualPayoffRegionBuilder toBuilder();
	
	static FxAccrualPayoffRegion.FxAccrualPayoffRegionBuilder builder() {
		return new FxAccrualPayoffRegion.FxAccrualPayoffRegionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxAccrualPayoffRegion> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxAccrualPayoffRegion> getType() {
		return FxAccrualPayoffRegion.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxAccrualPayoffRegionBuilder extends FxAccrualPayoffRegion, RosettaModelObjectBuilder {
		FxAccrualPayoffRegion.FxAccrualPayoffRegionBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		FxAccrualPayoffRegion.FxAccrualPayoffRegionBuilder prune();
	}

	/*********************** Immutable Implementation of FxAccrualPayoffRegion  ***********************/
	class FxAccrualPayoffRegionImpl implements FxAccrualPayoffRegion {
		private final String id;
		
		protected FxAccrualPayoffRegionImpl(FxAccrualPayoffRegion.FxAccrualPayoffRegionBuilder builder) {
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public FxAccrualPayoffRegion build() {
			return this;
		}
		
		@Override
		public FxAccrualPayoffRegion.FxAccrualPayoffRegionBuilder toBuilder() {
			FxAccrualPayoffRegion.FxAccrualPayoffRegionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxAccrualPayoffRegion.FxAccrualPayoffRegionBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxAccrualPayoffRegion _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxAccrualPayoffRegion {" +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of FxAccrualPayoffRegion  ***********************/
	class FxAccrualPayoffRegionBuilderImpl implements FxAccrualPayoffRegion.FxAccrualPayoffRegionBuilder {
	
		protected String id;
	
		public FxAccrualPayoffRegionBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("id")
		public FxAccrualPayoffRegion.FxAccrualPayoffRegionBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public FxAccrualPayoffRegion build() {
			return new FxAccrualPayoffRegion.FxAccrualPayoffRegionImpl(this);
		}
		
		@Override
		public FxAccrualPayoffRegion.FxAccrualPayoffRegionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAccrualPayoffRegion.FxAccrualPayoffRegionBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAccrualPayoffRegion.FxAccrualPayoffRegionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxAccrualPayoffRegion.FxAccrualPayoffRegionBuilder o = (FxAccrualPayoffRegion.FxAccrualPayoffRegionBuilder) other;
			
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxAccrualPayoffRegion _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxAccrualPayoffRegionBuilder {" +
				"id=" + this.id +
			'}';
		}
	}
}
