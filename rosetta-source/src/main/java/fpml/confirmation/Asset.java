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
import fpml.confirmation.Asset;
import fpml.confirmation.Asset.AssetBuilder;
import fpml.confirmation.Asset.AssetBuilderImpl;
import fpml.confirmation.Asset.AssetImpl;
import fpml.confirmation.meta.AssetMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Abstract base class for all underlying assets.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="Asset", builder=Asset.AssetBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface Asset extends RosettaModelObject {

	AssetMeta metaData = new AssetMeta();

	/*********************** Getter Methods  ***********************/
	String getId();

	/*********************** Build Methods  ***********************/
	Asset build();
	
	Asset.AssetBuilder toBuilder();
	
	static Asset.AssetBuilder builder() {
		return new Asset.AssetBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Asset> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends Asset> getType() {
		return Asset.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AssetBuilder extends Asset, RosettaModelObjectBuilder {
		Asset.AssetBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		Asset.AssetBuilder prune();
	}

	/*********************** Immutable Implementation of Asset  ***********************/
	class AssetImpl implements Asset {
		private final String id;
		
		protected AssetImpl(Asset.AssetBuilder builder) {
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public Asset build() {
			return this;
		}
		
		@Override
		public Asset.AssetBuilder toBuilder() {
			Asset.AssetBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Asset.AssetBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Asset _that = getType().cast(o);
		
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
			return "Asset {" +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of Asset  ***********************/
	class AssetBuilderImpl implements Asset.AssetBuilder {
	
		protected String id;
	
		public AssetBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("id")
		public Asset.AssetBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public Asset build() {
			return new Asset.AssetImpl(this);
		}
		
		@Override
		public Asset.AssetBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Asset.AssetBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Asset.AssetBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Asset.AssetBuilder o = (Asset.AssetBuilder) other;
			
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Asset _that = getType().cast(o);
		
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
			return "AssetBuilder {" +
				"id=" + this.id +
			'}';
		}
	}
}
