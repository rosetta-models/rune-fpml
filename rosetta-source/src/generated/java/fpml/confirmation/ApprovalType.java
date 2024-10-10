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
import fpml.confirmation.ApprovalType;
import fpml.confirmation.ApprovalType.ApprovalTypeBuilder;
import fpml.confirmation.ApprovalType.ApprovalTypeBuilderImpl;
import fpml.confirmation.ApprovalType.ApprovalTypeImpl;
import fpml.confirmation.meta.ApprovalTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type that qualifies the type of approval.
 * @version ${project.version}
 */
@RosettaDataType(value="ApprovalType", builder=ApprovalType.ApprovalTypeBuilderImpl.class, version="${project.version}")
public interface ApprovalType extends RosettaModelObject {

	ApprovalTypeMeta metaData = new ApprovalTypeMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getApprovalTypeScheme();

	/*********************** Build Methods  ***********************/
	ApprovalType build();
	
	ApprovalType.ApprovalTypeBuilder toBuilder();
	
	static ApprovalType.ApprovalTypeBuilder builder() {
		return new ApprovalType.ApprovalTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ApprovalType> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ApprovalType> getType() {
		return ApprovalType.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("approvalTypeScheme"), String.class, getApprovalTypeScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ApprovalTypeBuilder extends ApprovalType, RosettaModelObjectBuilder {
		ApprovalType.ApprovalTypeBuilder setValue(String value);
		ApprovalType.ApprovalTypeBuilder setApprovalTypeScheme(String approvalTypeScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("approvalTypeScheme"), String.class, getApprovalTypeScheme(), this);
		}
		

		ApprovalType.ApprovalTypeBuilder prune();
	}

	/*********************** Immutable Implementation of ApprovalType  ***********************/
	class ApprovalTypeImpl implements ApprovalType {
		private final String value;
		private final String approvalTypeScheme;
		
		protected ApprovalTypeImpl(ApprovalType.ApprovalTypeBuilder builder) {
			this.value = builder.getValue();
			this.approvalTypeScheme = builder.getApprovalTypeScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("approvalTypeScheme")
		public String getApprovalTypeScheme() {
			return approvalTypeScheme;
		}
		
		@Override
		public ApprovalType build() {
			return this;
		}
		
		@Override
		public ApprovalType.ApprovalTypeBuilder toBuilder() {
			ApprovalType.ApprovalTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ApprovalType.ApprovalTypeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getApprovalTypeScheme()).ifPresent(builder::setApprovalTypeScheme);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ApprovalType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(approvalTypeScheme, _that.getApprovalTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (approvalTypeScheme != null ? approvalTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ApprovalType {" +
				"value=" + this.value + ", " +
				"approvalTypeScheme=" + this.approvalTypeScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of ApprovalType  ***********************/
	class ApprovalTypeBuilderImpl implements ApprovalType.ApprovalTypeBuilder {
	
		protected String value;
		protected String approvalTypeScheme;
	
		public ApprovalTypeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("approvalTypeScheme")
		public String getApprovalTypeScheme() {
			return approvalTypeScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public ApprovalType.ApprovalTypeBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("approvalTypeScheme")
		public ApprovalType.ApprovalTypeBuilder setApprovalTypeScheme(String approvalTypeScheme) {
			this.approvalTypeScheme = approvalTypeScheme==null?null:approvalTypeScheme;
			return this;
		}
		
		@Override
		public ApprovalType build() {
			return new ApprovalType.ApprovalTypeImpl(this);
		}
		
		@Override
		public ApprovalType.ApprovalTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ApprovalType.ApprovalTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getApprovalTypeScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ApprovalType.ApprovalTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ApprovalType.ApprovalTypeBuilder o = (ApprovalType.ApprovalTypeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getApprovalTypeScheme(), o.getApprovalTypeScheme(), this::setApprovalTypeScheme);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ApprovalType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(approvalTypeScheme, _that.getApprovalTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (approvalTypeScheme != null ? approvalTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ApprovalTypeBuilder {" +
				"value=" + this.value + ", " +
				"approvalTypeScheme=" + this.approvalTypeScheme +
			'}';
		}
	}
}
