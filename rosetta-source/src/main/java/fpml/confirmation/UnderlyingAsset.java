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
import fpml.confirmation.UnderlyingAsset;
import fpml.confirmation.UnderlyingAsset.UnderlyingAssetBuilder;
import fpml.confirmation.UnderlyingAsset.UnderlyingAssetBuilderImpl;
import fpml.confirmation.UnderlyingAsset.UnderlyingAssetImpl;
import fpml.confirmation.meta.UnderlyingAssetMeta;


/**
 * Define the underlying asset, either a listed security or other instrument.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="UnderlyingAsset", builder=UnderlyingAsset.UnderlyingAssetBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface UnderlyingAsset extends Asset {

	UnderlyingAssetMeta metaData = new UnderlyingAssetMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	UnderlyingAsset build();
	
	UnderlyingAsset.UnderlyingAssetBuilder toBuilder();
	
	static UnderlyingAsset.UnderlyingAssetBuilder builder() {
		return new UnderlyingAsset.UnderlyingAssetBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends UnderlyingAsset> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends UnderlyingAsset> getType() {
		return UnderlyingAsset.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface UnderlyingAssetBuilder extends UnderlyingAsset, Asset.AssetBuilder {
		UnderlyingAsset.UnderlyingAssetBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		UnderlyingAsset.UnderlyingAssetBuilder prune();
	}

	/*********************** Immutable Implementation of UnderlyingAsset  ***********************/
	class UnderlyingAssetImpl extends Asset.AssetImpl implements UnderlyingAsset {
		
		protected UnderlyingAssetImpl(UnderlyingAsset.UnderlyingAssetBuilder builder) {
			super(builder);
		}
		
		@Override
		public UnderlyingAsset build() {
			return this;
		}
		
		@Override
		public UnderlyingAsset.UnderlyingAssetBuilder toBuilder() {
			UnderlyingAsset.UnderlyingAssetBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(UnderlyingAsset.UnderlyingAssetBuilder builder) {
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
			return "UnderlyingAsset {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of UnderlyingAsset  ***********************/
	class UnderlyingAssetBuilderImpl extends Asset.AssetBuilderImpl  implements UnderlyingAsset.UnderlyingAssetBuilder {
	
	
		public UnderlyingAssetBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("id")
		public UnderlyingAsset.UnderlyingAssetBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public UnderlyingAsset build() {
			return new UnderlyingAsset.UnderlyingAssetImpl(this);
		}
		
		@Override
		public UnderlyingAsset.UnderlyingAssetBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public UnderlyingAsset.UnderlyingAssetBuilder prune() {
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
		public UnderlyingAsset.UnderlyingAssetBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			UnderlyingAsset.UnderlyingAssetBuilder o = (UnderlyingAsset.UnderlyingAssetBuilder) other;
			
			
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
			return "UnderlyingAssetBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
