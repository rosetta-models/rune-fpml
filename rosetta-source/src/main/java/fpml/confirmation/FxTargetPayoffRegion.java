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
import fpml.confirmation.FxTargetPayoffRegion;
import fpml.confirmation.FxTargetPayoffRegion.FxTargetPayoffRegionBuilder;
import fpml.confirmation.FxTargetPayoffRegion.FxTargetPayoffRegionBuilderImpl;
import fpml.confirmation.FxTargetPayoffRegion.FxTargetPayoffRegionImpl;
import fpml.confirmation.meta.FxTargetPayoffRegionMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="FxTargetPayoffRegion", builder=FxTargetPayoffRegion.FxTargetPayoffRegionBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface FxTargetPayoffRegion extends RosettaModelObject {

	FxTargetPayoffRegionMeta metaData = new FxTargetPayoffRegionMeta();

	/*********************** Getter Methods  ***********************/
	String getId();

	/*********************** Build Methods  ***********************/
	FxTargetPayoffRegion build();
	
	FxTargetPayoffRegion.FxTargetPayoffRegionBuilder toBuilder();
	
	static FxTargetPayoffRegion.FxTargetPayoffRegionBuilder builder() {
		return new FxTargetPayoffRegion.FxTargetPayoffRegionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxTargetPayoffRegion> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxTargetPayoffRegion> getType() {
		return FxTargetPayoffRegion.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxTargetPayoffRegionBuilder extends FxTargetPayoffRegion, RosettaModelObjectBuilder {
		FxTargetPayoffRegion.FxTargetPayoffRegionBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		FxTargetPayoffRegion.FxTargetPayoffRegionBuilder prune();
	}

	/*********************** Immutable Implementation of FxTargetPayoffRegion  ***********************/
	class FxTargetPayoffRegionImpl implements FxTargetPayoffRegion {
		private final String id;
		
		protected FxTargetPayoffRegionImpl(FxTargetPayoffRegion.FxTargetPayoffRegionBuilder builder) {
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public FxTargetPayoffRegion build() {
			return this;
		}
		
		@Override
		public FxTargetPayoffRegion.FxTargetPayoffRegionBuilder toBuilder() {
			FxTargetPayoffRegion.FxTargetPayoffRegionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxTargetPayoffRegion.FxTargetPayoffRegionBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxTargetPayoffRegion _that = getType().cast(o);
		
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
			return "FxTargetPayoffRegion {" +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of FxTargetPayoffRegion  ***********************/
	class FxTargetPayoffRegionBuilderImpl implements FxTargetPayoffRegion.FxTargetPayoffRegionBuilder {
	
		protected String id;
	
		public FxTargetPayoffRegionBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("id")
		public FxTargetPayoffRegion.FxTargetPayoffRegionBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public FxTargetPayoffRegion build() {
			return new FxTargetPayoffRegion.FxTargetPayoffRegionImpl(this);
		}
		
		@Override
		public FxTargetPayoffRegion.FxTargetPayoffRegionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxTargetPayoffRegion.FxTargetPayoffRegionBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxTargetPayoffRegion.FxTargetPayoffRegionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxTargetPayoffRegion.FxTargetPayoffRegionBuilder o = (FxTargetPayoffRegion.FxTargetPayoffRegionBuilder) other;
			
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxTargetPayoffRegion _that = getType().cast(o);
		
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
			return "FxTargetPayoffRegionBuilder {" +
				"id=" + this.id +
			'}';
		}
	}
}
