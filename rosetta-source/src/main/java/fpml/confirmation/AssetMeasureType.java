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
import fpml.confirmation.AssetMeasureType;
import fpml.confirmation.AssetMeasureType.AssetMeasureTypeBuilder;
import fpml.confirmation.AssetMeasureType.AssetMeasureTypeBuilderImpl;
import fpml.confirmation.AssetMeasureType.AssetMeasureTypeImpl;
import fpml.confirmation.meta.AssetMeasureTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A scheme identifying the types of measures that can be used to describe an asset.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="AssetMeasureType", builder=AssetMeasureType.AssetMeasureTypeBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface AssetMeasureType extends RosettaModelObject {

	AssetMeasureTypeMeta metaData = new AssetMeasureTypeMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getAssetMeasureScheme();

	/*********************** Build Methods  ***********************/
	AssetMeasureType build();
	
	AssetMeasureType.AssetMeasureTypeBuilder toBuilder();
	
	static AssetMeasureType.AssetMeasureTypeBuilder builder() {
		return new AssetMeasureType.AssetMeasureTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AssetMeasureType> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends AssetMeasureType> getType() {
		return AssetMeasureType.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("assetMeasureScheme"), String.class, getAssetMeasureScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AssetMeasureTypeBuilder extends AssetMeasureType, RosettaModelObjectBuilder {
		AssetMeasureType.AssetMeasureTypeBuilder setValue(String value);
		AssetMeasureType.AssetMeasureTypeBuilder setAssetMeasureScheme(String assetMeasureScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("assetMeasureScheme"), String.class, getAssetMeasureScheme(), this);
		}
		

		AssetMeasureType.AssetMeasureTypeBuilder prune();
	}

	/*********************** Immutable Implementation of AssetMeasureType  ***********************/
	class AssetMeasureTypeImpl implements AssetMeasureType {
		private final String value;
		private final String assetMeasureScheme;
		
		protected AssetMeasureTypeImpl(AssetMeasureType.AssetMeasureTypeBuilder builder) {
			this.value = builder.getValue();
			this.assetMeasureScheme = builder.getAssetMeasureScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("assetMeasureScheme")
		public String getAssetMeasureScheme() {
			return assetMeasureScheme;
		}
		
		@Override
		public AssetMeasureType build() {
			return this;
		}
		
		@Override
		public AssetMeasureType.AssetMeasureTypeBuilder toBuilder() {
			AssetMeasureType.AssetMeasureTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AssetMeasureType.AssetMeasureTypeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getAssetMeasureScheme()).ifPresent(builder::setAssetMeasureScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AssetMeasureType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(assetMeasureScheme, _that.getAssetMeasureScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (assetMeasureScheme != null ? assetMeasureScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AssetMeasureType {" +
				"value=" + this.value + ", " +
				"assetMeasureScheme=" + this.assetMeasureScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of AssetMeasureType  ***********************/
	class AssetMeasureTypeBuilderImpl implements AssetMeasureType.AssetMeasureTypeBuilder {
	
		protected String value;
		protected String assetMeasureScheme;
	
		public AssetMeasureTypeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("assetMeasureScheme")
		public String getAssetMeasureScheme() {
			return assetMeasureScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public AssetMeasureType.AssetMeasureTypeBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("assetMeasureScheme")
		public AssetMeasureType.AssetMeasureTypeBuilder setAssetMeasureScheme(String assetMeasureScheme) {
			this.assetMeasureScheme = assetMeasureScheme==null?null:assetMeasureScheme;
			return this;
		}
		
		@Override
		public AssetMeasureType build() {
			return new AssetMeasureType.AssetMeasureTypeImpl(this);
		}
		
		@Override
		public AssetMeasureType.AssetMeasureTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AssetMeasureType.AssetMeasureTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getAssetMeasureScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AssetMeasureType.AssetMeasureTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AssetMeasureType.AssetMeasureTypeBuilder o = (AssetMeasureType.AssetMeasureTypeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getAssetMeasureScheme(), o.getAssetMeasureScheme(), this::setAssetMeasureScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AssetMeasureType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(assetMeasureScheme, _that.getAssetMeasureScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (assetMeasureScheme != null ? assetMeasureScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AssetMeasureTypeBuilder {" +
				"value=" + this.value + ", " +
				"assetMeasureScheme=" + this.assetMeasureScheme +
			'}';
		}
	}
}
