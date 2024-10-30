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
import fpml.confirmation.MimeType;
import fpml.confirmation.MimeType.MimeTypeBuilder;
import fpml.confirmation.MimeType.MimeTypeBuilderImpl;
import fpml.confirmation.MimeType.MimeTypeImpl;
import fpml.confirmation.meta.MimeTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The type that indicates the type of media used to store the content. MimeType is used to determine the software product(s) that can read the content. MIME types are described in RFC 2046.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="MimeType", builder=MimeType.MimeTypeBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface MimeType extends RosettaModelObject {

	MimeTypeMeta metaData = new MimeTypeMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getMimeTypeScheme();

	/*********************** Build Methods  ***********************/
	MimeType build();
	
	MimeType.MimeTypeBuilder toBuilder();
	
	static MimeType.MimeTypeBuilder builder() {
		return new MimeType.MimeTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MimeType> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends MimeType> getType() {
		return MimeType.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("mimeTypeScheme"), String.class, getMimeTypeScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface MimeTypeBuilder extends MimeType, RosettaModelObjectBuilder {
		MimeType.MimeTypeBuilder setValue(String value);
		MimeType.MimeTypeBuilder setMimeTypeScheme(String mimeTypeScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("mimeTypeScheme"), String.class, getMimeTypeScheme(), this);
		}
		

		MimeType.MimeTypeBuilder prune();
	}

	/*********************** Immutable Implementation of MimeType  ***********************/
	class MimeTypeImpl implements MimeType {
		private final String value;
		private final String mimeTypeScheme;
		
		protected MimeTypeImpl(MimeType.MimeTypeBuilder builder) {
			this.value = builder.getValue();
			this.mimeTypeScheme = builder.getMimeTypeScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("mimeTypeScheme")
		public String getMimeTypeScheme() {
			return mimeTypeScheme;
		}
		
		@Override
		public MimeType build() {
			return this;
		}
		
		@Override
		public MimeType.MimeTypeBuilder toBuilder() {
			MimeType.MimeTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MimeType.MimeTypeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getMimeTypeScheme()).ifPresent(builder::setMimeTypeScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MimeType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(mimeTypeScheme, _that.getMimeTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (mimeTypeScheme != null ? mimeTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MimeType {" +
				"value=" + this.value + ", " +
				"mimeTypeScheme=" + this.mimeTypeScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of MimeType  ***********************/
	class MimeTypeBuilderImpl implements MimeType.MimeTypeBuilder {
	
		protected String value;
		protected String mimeTypeScheme;
	
		public MimeTypeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("mimeTypeScheme")
		public String getMimeTypeScheme() {
			return mimeTypeScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public MimeType.MimeTypeBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("mimeTypeScheme")
		public MimeType.MimeTypeBuilder setMimeTypeScheme(String mimeTypeScheme) {
			this.mimeTypeScheme = mimeTypeScheme==null?null:mimeTypeScheme;
			return this;
		}
		
		@Override
		public MimeType build() {
			return new MimeType.MimeTypeImpl(this);
		}
		
		@Override
		public MimeType.MimeTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MimeType.MimeTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getMimeTypeScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MimeType.MimeTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			MimeType.MimeTypeBuilder o = (MimeType.MimeTypeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getMimeTypeScheme(), o.getMimeTypeScheme(), this::setMimeTypeScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MimeType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(mimeTypeScheme, _that.getMimeTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (mimeTypeScheme != null ? mimeTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MimeTypeBuilder {" +
				"value=" + this.value + ", " +
				"mimeTypeScheme=" + this.mimeTypeScheme +
			'}';
		}
	}
}
