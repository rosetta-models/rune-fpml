package cdm.observable.asset.metafields;

import cdm.observable.asset.FloatingRateIndex;
import com.rosetta.model.lib.GlobalKey;
import com.rosetta.model.lib.GlobalKey.GlobalKeyBuilder;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.BasicRosettaMetaData;
import com.rosetta.model.lib.meta.FieldWithMeta;
import com.rosetta.model.lib.meta.FieldWithMeta.FieldWithMetaBuilder;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.metafields.MetaFields;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 1
 */
@RosettaDataType(value="FieldWithMetaFloatingRateIndex", builder=FieldWithMetaFloatingRateIndex.FieldWithMetaFloatingRateIndexBuilderImpl.class, version="0.0.0")
public interface FieldWithMetaFloatingRateIndex extends RosettaModelObject, FieldWithMeta<FloatingRateIndex>, GlobalKey {

	FieldWithMetaFloatingRateIndexMeta metaData = new FieldWithMetaFloatingRateIndexMeta();

	/*********************** Getter Methods  ***********************/
	FloatingRateIndex getValue();
	MetaFields getMeta();

	/*********************** Build Methods  ***********************/
	FieldWithMetaFloatingRateIndex build();
	
	FieldWithMetaFloatingRateIndex.FieldWithMetaFloatingRateIndexBuilder toBuilder();
	
	static FieldWithMetaFloatingRateIndex.FieldWithMetaFloatingRateIndexBuilder builder() {
		return new FieldWithMetaFloatingRateIndex.FieldWithMetaFloatingRateIndexBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FieldWithMetaFloatingRateIndex> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FieldWithMetaFloatingRateIndex> getType() {
		return FieldWithMetaFloatingRateIndex.class;
	}
	
	@Override
	default Class<FloatingRateIndex> getValueType() {
		return FloatingRateIndex.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("value"), processor, FloatingRateIndex.class, getValue());
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FieldWithMetaFloatingRateIndexBuilder extends FieldWithMetaFloatingRateIndex, RosettaModelObjectBuilder, GlobalKey.GlobalKeyBuilder, FieldWithMeta.FieldWithMetaBuilder<FloatingRateIndex> {
		FloatingRateIndex.FloatingRateIndexBuilder getOrCreateValue();
		FloatingRateIndex.FloatingRateIndexBuilder getValue();
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		FieldWithMetaFloatingRateIndex.FieldWithMetaFloatingRateIndexBuilder setValue(FloatingRateIndex value);
		FieldWithMetaFloatingRateIndex.FieldWithMetaFloatingRateIndexBuilder setMeta(MetaFields meta);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("value"), processor, FloatingRateIndex.FloatingRateIndexBuilder.class, getValue());
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
		}
		

		FieldWithMetaFloatingRateIndex.FieldWithMetaFloatingRateIndexBuilder prune();
	}

	/*********************** Immutable Implementation of FieldWithMetaFloatingRateIndex  ***********************/
	class FieldWithMetaFloatingRateIndexImpl implements FieldWithMetaFloatingRateIndex {
		private final FloatingRateIndex value;
		private final MetaFields meta;
		
		protected FieldWithMetaFloatingRateIndexImpl(FieldWithMetaFloatingRateIndex.FieldWithMetaFloatingRateIndexBuilder builder) {
			this.value = ofNullable(builder.getValue()).map(f->f.build()).orElse(null);
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("value")
		public FloatingRateIndex getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("meta")
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public FieldWithMetaFloatingRateIndex build() {
			return this;
		}
		
		@Override
		public FieldWithMetaFloatingRateIndex.FieldWithMetaFloatingRateIndexBuilder toBuilder() {
			FieldWithMetaFloatingRateIndex.FieldWithMetaFloatingRateIndexBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FieldWithMetaFloatingRateIndex.FieldWithMetaFloatingRateIndexBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getMeta()).ifPresent(builder::setMeta);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FieldWithMetaFloatingRateIndex _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FieldWithMetaFloatingRateIndex {" +
				"value=" + this.value + ", " +
				"meta=" + this.meta +
			'}';
		}
	}

	/*********************** Builder Implementation of FieldWithMetaFloatingRateIndex  ***********************/
	class FieldWithMetaFloatingRateIndexBuilderImpl implements FieldWithMetaFloatingRateIndex.FieldWithMetaFloatingRateIndexBuilder {
	
		protected FloatingRateIndex.FloatingRateIndexBuilder value;
		protected MetaFields.MetaFieldsBuilder meta;
	
		public FieldWithMetaFloatingRateIndexBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public FloatingRateIndex.FloatingRateIndexBuilder getValue() {
			return value;
		}
		
		@Override
		public FloatingRateIndex.FloatingRateIndexBuilder getOrCreateValue() {
			FloatingRateIndex.FloatingRateIndexBuilder result;
			if (value!=null) {
				result = value;
			}
			else {
				result = value = FloatingRateIndex.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("meta")
		public MetaFields.MetaFieldsBuilder getMeta() {
			return meta;
		}
		
		@Override
		public MetaFields.MetaFieldsBuilder getOrCreateMeta() {
			MetaFields.MetaFieldsBuilder result;
			if (meta!=null) {
				result = meta;
			}
			else {
				result = meta = MetaFields.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("value")
		public FieldWithMetaFloatingRateIndex.FieldWithMetaFloatingRateIndexBuilder setValue(FloatingRateIndex value) {
			this.value = value==null?null:value.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("meta")
		public FieldWithMetaFloatingRateIndex.FieldWithMetaFloatingRateIndexBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		
		@Override
		public FieldWithMetaFloatingRateIndex build() {
			return new FieldWithMetaFloatingRateIndex.FieldWithMetaFloatingRateIndexImpl(this);
		}
		
		@Override
		public FieldWithMetaFloatingRateIndex.FieldWithMetaFloatingRateIndexBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FieldWithMetaFloatingRateIndex.FieldWithMetaFloatingRateIndexBuilder prune() {
			if (value!=null && !value.prune().hasData()) value = null;
			if (meta!=null && !meta.prune().hasData()) meta = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null && getValue().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FieldWithMetaFloatingRateIndex.FieldWithMetaFloatingRateIndexBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FieldWithMetaFloatingRateIndex.FieldWithMetaFloatingRateIndexBuilder o = (FieldWithMetaFloatingRateIndex.FieldWithMetaFloatingRateIndexBuilder) other;
			
			merger.mergeRosetta(getValue(), o.getValue(), this::setValue);
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FieldWithMetaFloatingRateIndex _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FieldWithMetaFloatingRateIndexBuilder {" +
				"value=" + this.value + ", " +
				"meta=" + this.meta +
			'}';
		}
	}
}

class FieldWithMetaFloatingRateIndexMeta extends BasicRosettaMetaData<FieldWithMetaFloatingRateIndex>{

}
