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
import fpml.confirmation.AssetReference;
import fpml.confirmation.UnderlyingAssetOrReferenceModel;
import fpml.confirmation.UnderlyingAssetOrReferenceModel.UnderlyingAssetOrReferenceModelBuilder;
import fpml.confirmation.UnderlyingAssetOrReferenceModel.UnderlyingAssetOrReferenceModelBuilderImpl;
import fpml.confirmation.UnderlyingAssetOrReferenceModel.UnderlyingAssetOrReferenceModelImpl;
import fpml.confirmation.meta.UnderlyingAssetOrReferenceModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Include or reference an underlying asset definition.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="UnderlyingAssetOrReferenceModel", builder=UnderlyingAssetOrReferenceModel.UnderlyingAssetOrReferenceModelBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface UnderlyingAssetOrReferenceModel extends RosettaModelObject {

	UnderlyingAssetOrReferenceModelMeta metaData = new UnderlyingAssetOrReferenceModelMeta();

	/*********************** Getter Methods  ***********************/
	Asset getUnderlyingAsset();
	/**
	 * A reference to an underlying asset that defines the meaning of the value, i.e. the product that the value corresponds to. For example, this could be a caplet or simple european swaption.
	 */
	AssetReference getUnderlyingAssetReference();

	/*********************** Build Methods  ***********************/
	UnderlyingAssetOrReferenceModel build();
	
	UnderlyingAssetOrReferenceModel.UnderlyingAssetOrReferenceModelBuilder toBuilder();
	
	static UnderlyingAssetOrReferenceModel.UnderlyingAssetOrReferenceModelBuilder builder() {
		return new UnderlyingAssetOrReferenceModel.UnderlyingAssetOrReferenceModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends UnderlyingAssetOrReferenceModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends UnderlyingAssetOrReferenceModel> getType() {
		return UnderlyingAssetOrReferenceModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("underlyingAsset"), processor, Asset.class, getUnderlyingAsset());
		processRosetta(path.newSubPath("underlyingAssetReference"), processor, AssetReference.class, getUnderlyingAssetReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface UnderlyingAssetOrReferenceModelBuilder extends UnderlyingAssetOrReferenceModel, RosettaModelObjectBuilder {
		Asset.AssetBuilder getOrCreateUnderlyingAsset();
		Asset.AssetBuilder getUnderlyingAsset();
		AssetReference.AssetReferenceBuilder getOrCreateUnderlyingAssetReference();
		AssetReference.AssetReferenceBuilder getUnderlyingAssetReference();
		UnderlyingAssetOrReferenceModel.UnderlyingAssetOrReferenceModelBuilder setUnderlyingAsset(Asset underlyingAsset);
		UnderlyingAssetOrReferenceModel.UnderlyingAssetOrReferenceModelBuilder setUnderlyingAssetReference(AssetReference underlyingAssetReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("underlyingAsset"), processor, Asset.AssetBuilder.class, getUnderlyingAsset());
			processRosetta(path.newSubPath("underlyingAssetReference"), processor, AssetReference.AssetReferenceBuilder.class, getUnderlyingAssetReference());
		}
		

		UnderlyingAssetOrReferenceModel.UnderlyingAssetOrReferenceModelBuilder prune();
	}

	/*********************** Immutable Implementation of UnderlyingAssetOrReferenceModel  ***********************/
	class UnderlyingAssetOrReferenceModelImpl implements UnderlyingAssetOrReferenceModel {
		private final Asset underlyingAsset;
		private final AssetReference underlyingAssetReference;
		
		protected UnderlyingAssetOrReferenceModelImpl(UnderlyingAssetOrReferenceModel.UnderlyingAssetOrReferenceModelBuilder builder) {
			this.underlyingAsset = ofNullable(builder.getUnderlyingAsset()).map(f->f.build()).orElse(null);
			this.underlyingAssetReference = ofNullable(builder.getUnderlyingAssetReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("underlyingAsset")
		public Asset getUnderlyingAsset() {
			return underlyingAsset;
		}
		
		@Override
		@RosettaAttribute("underlyingAssetReference")
		public AssetReference getUnderlyingAssetReference() {
			return underlyingAssetReference;
		}
		
		@Override
		public UnderlyingAssetOrReferenceModel build() {
			return this;
		}
		
		@Override
		public UnderlyingAssetOrReferenceModel.UnderlyingAssetOrReferenceModelBuilder toBuilder() {
			UnderlyingAssetOrReferenceModel.UnderlyingAssetOrReferenceModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(UnderlyingAssetOrReferenceModel.UnderlyingAssetOrReferenceModelBuilder builder) {
			ofNullable(getUnderlyingAsset()).ifPresent(builder::setUnderlyingAsset);
			ofNullable(getUnderlyingAssetReference()).ifPresent(builder::setUnderlyingAssetReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			UnderlyingAssetOrReferenceModel _that = getType().cast(o);
		
			if (!Objects.equals(underlyingAsset, _that.getUnderlyingAsset())) return false;
			if (!Objects.equals(underlyingAssetReference, _that.getUnderlyingAssetReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (underlyingAsset != null ? underlyingAsset.hashCode() : 0);
			_result = 31 * _result + (underlyingAssetReference != null ? underlyingAssetReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "UnderlyingAssetOrReferenceModel {" +
				"underlyingAsset=" + this.underlyingAsset + ", " +
				"underlyingAssetReference=" + this.underlyingAssetReference +
			'}';
		}
	}

	/*********************** Builder Implementation of UnderlyingAssetOrReferenceModel  ***********************/
	class UnderlyingAssetOrReferenceModelBuilderImpl implements UnderlyingAssetOrReferenceModel.UnderlyingAssetOrReferenceModelBuilder {
	
		protected Asset.AssetBuilder underlyingAsset;
		protected AssetReference.AssetReferenceBuilder underlyingAssetReference;
	
		public UnderlyingAssetOrReferenceModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("underlyingAsset")
		public Asset.AssetBuilder getUnderlyingAsset() {
			return underlyingAsset;
		}
		
		@Override
		public Asset.AssetBuilder getOrCreateUnderlyingAsset() {
			Asset.AssetBuilder result;
			if (underlyingAsset!=null) {
				result = underlyingAsset;
			}
			else {
				result = underlyingAsset = Asset.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("underlyingAssetReference")
		public AssetReference.AssetReferenceBuilder getUnderlyingAssetReference() {
			return underlyingAssetReference;
		}
		
		@Override
		public AssetReference.AssetReferenceBuilder getOrCreateUnderlyingAssetReference() {
			AssetReference.AssetReferenceBuilder result;
			if (underlyingAssetReference!=null) {
				result = underlyingAssetReference;
			}
			else {
				result = underlyingAssetReference = AssetReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("underlyingAsset")
		public UnderlyingAssetOrReferenceModel.UnderlyingAssetOrReferenceModelBuilder setUnderlyingAsset(Asset underlyingAsset) {
			this.underlyingAsset = underlyingAsset==null?null:underlyingAsset.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("underlyingAssetReference")
		public UnderlyingAssetOrReferenceModel.UnderlyingAssetOrReferenceModelBuilder setUnderlyingAssetReference(AssetReference underlyingAssetReference) {
			this.underlyingAssetReference = underlyingAssetReference==null?null:underlyingAssetReference.toBuilder();
			return this;
		}
		
		@Override
		public UnderlyingAssetOrReferenceModel build() {
			return new UnderlyingAssetOrReferenceModel.UnderlyingAssetOrReferenceModelImpl(this);
		}
		
		@Override
		public UnderlyingAssetOrReferenceModel.UnderlyingAssetOrReferenceModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public UnderlyingAssetOrReferenceModel.UnderlyingAssetOrReferenceModelBuilder prune() {
			if (underlyingAsset!=null && !underlyingAsset.prune().hasData()) underlyingAsset = null;
			if (underlyingAssetReference!=null && !underlyingAssetReference.prune().hasData()) underlyingAssetReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getUnderlyingAsset()!=null && getUnderlyingAsset().hasData()) return true;
			if (getUnderlyingAssetReference()!=null && getUnderlyingAssetReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public UnderlyingAssetOrReferenceModel.UnderlyingAssetOrReferenceModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			UnderlyingAssetOrReferenceModel.UnderlyingAssetOrReferenceModelBuilder o = (UnderlyingAssetOrReferenceModel.UnderlyingAssetOrReferenceModelBuilder) other;
			
			merger.mergeRosetta(getUnderlyingAsset(), o.getUnderlyingAsset(), this::setUnderlyingAsset);
			merger.mergeRosetta(getUnderlyingAssetReference(), o.getUnderlyingAssetReference(), this::setUnderlyingAssetReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			UnderlyingAssetOrReferenceModel _that = getType().cast(o);
		
			if (!Objects.equals(underlyingAsset, _that.getUnderlyingAsset())) return false;
			if (!Objects.equals(underlyingAssetReference, _that.getUnderlyingAssetReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (underlyingAsset != null ? underlyingAsset.hashCode() : 0);
			_result = 31 * _result + (underlyingAssetReference != null ? underlyingAssetReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "UnderlyingAssetOrReferenceModelBuilder {" +
				"underlyingAsset=" + this.underlyingAsset + ", " +
				"underlyingAssetReference=" + this.underlyingAssetReference +
			'}';
		}
	}
}
