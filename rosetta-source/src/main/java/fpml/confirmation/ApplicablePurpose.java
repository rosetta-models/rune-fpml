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
import fpml.confirmation.ApplicablePurpose;
import fpml.confirmation.ApplicablePurpose.ApplicablePurposeBuilder;
import fpml.confirmation.ApplicablePurpose.ApplicablePurposeBuilderImpl;
import fpml.confirmation.ApplicablePurpose.ApplicablePurposeImpl;
import fpml.confirmation.meta.ApplicablePurposeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A scheme that describes the purpose of a contact in relation to an asset or assets.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="ApplicablePurpose", builder=ApplicablePurpose.ApplicablePurposeBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface ApplicablePurpose extends RosettaModelObject {

	ApplicablePurposeMeta metaData = new ApplicablePurposeMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getApplicablePurposeScheme();

	/*********************** Build Methods  ***********************/
	ApplicablePurpose build();
	
	ApplicablePurpose.ApplicablePurposeBuilder toBuilder();
	
	static ApplicablePurpose.ApplicablePurposeBuilder builder() {
		return new ApplicablePurpose.ApplicablePurposeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ApplicablePurpose> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ApplicablePurpose> getType() {
		return ApplicablePurpose.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("applicablePurposeScheme"), String.class, getApplicablePurposeScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ApplicablePurposeBuilder extends ApplicablePurpose, RosettaModelObjectBuilder {
		ApplicablePurpose.ApplicablePurposeBuilder setValue(String value);
		ApplicablePurpose.ApplicablePurposeBuilder setApplicablePurposeScheme(String applicablePurposeScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("applicablePurposeScheme"), String.class, getApplicablePurposeScheme(), this);
		}
		

		ApplicablePurpose.ApplicablePurposeBuilder prune();
	}

	/*********************** Immutable Implementation of ApplicablePurpose  ***********************/
	class ApplicablePurposeImpl implements ApplicablePurpose {
		private final String value;
		private final String applicablePurposeScheme;
		
		protected ApplicablePurposeImpl(ApplicablePurpose.ApplicablePurposeBuilder builder) {
			this.value = builder.getValue();
			this.applicablePurposeScheme = builder.getApplicablePurposeScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("applicablePurposeScheme")
		public String getApplicablePurposeScheme() {
			return applicablePurposeScheme;
		}
		
		@Override
		public ApplicablePurpose build() {
			return this;
		}
		
		@Override
		public ApplicablePurpose.ApplicablePurposeBuilder toBuilder() {
			ApplicablePurpose.ApplicablePurposeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ApplicablePurpose.ApplicablePurposeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getApplicablePurposeScheme()).ifPresent(builder::setApplicablePurposeScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ApplicablePurpose _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(applicablePurposeScheme, _that.getApplicablePurposeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (applicablePurposeScheme != null ? applicablePurposeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ApplicablePurpose {" +
				"value=" + this.value + ", " +
				"applicablePurposeScheme=" + this.applicablePurposeScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of ApplicablePurpose  ***********************/
	class ApplicablePurposeBuilderImpl implements ApplicablePurpose.ApplicablePurposeBuilder {
	
		protected String value;
		protected String applicablePurposeScheme;
	
		public ApplicablePurposeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("applicablePurposeScheme")
		public String getApplicablePurposeScheme() {
			return applicablePurposeScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public ApplicablePurpose.ApplicablePurposeBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("applicablePurposeScheme")
		public ApplicablePurpose.ApplicablePurposeBuilder setApplicablePurposeScheme(String applicablePurposeScheme) {
			this.applicablePurposeScheme = applicablePurposeScheme==null?null:applicablePurposeScheme;
			return this;
		}
		
		@Override
		public ApplicablePurpose build() {
			return new ApplicablePurpose.ApplicablePurposeImpl(this);
		}
		
		@Override
		public ApplicablePurpose.ApplicablePurposeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ApplicablePurpose.ApplicablePurposeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getApplicablePurposeScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ApplicablePurpose.ApplicablePurposeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ApplicablePurpose.ApplicablePurposeBuilder o = (ApplicablePurpose.ApplicablePurposeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getApplicablePurposeScheme(), o.getApplicablePurposeScheme(), this::setApplicablePurposeScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ApplicablePurpose _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(applicablePurposeScheme, _that.getApplicablePurposeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (applicablePurposeScheme != null ? applicablePurposeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ApplicablePurposeBuilder {" +
				"value=" + this.value + ", " +
				"applicablePurposeScheme=" + this.applicablePurposeScheme +
			'}';
		}
	}
}
