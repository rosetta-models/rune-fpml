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
import fpml.confirmation.ApprovalId;
import fpml.confirmation.ApprovalId.ApprovalIdBuilder;
import fpml.confirmation.ApprovalId.ApprovalIdBuilderImpl;
import fpml.confirmation.ApprovalId.ApprovalIdImpl;
import fpml.confirmation.meta.ApprovalIdMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * An approval identifier allocated by a party. FpML does not define the domain values associated with this element.
 * @version ${project.version}
 */
@RosettaDataType(value="ApprovalId", builder=ApprovalId.ApprovalIdBuilderImpl.class, version="${project.version}")
public interface ApprovalId extends RosettaModelObject {

	ApprovalIdMeta metaData = new ApprovalIdMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getApprovalIdScheme();
	String getId();

	/*********************** Build Methods  ***********************/
	ApprovalId build();
	
	ApprovalId.ApprovalIdBuilder toBuilder();
	
	static ApprovalId.ApprovalIdBuilder builder() {
		return new ApprovalId.ApprovalIdBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ApprovalId> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ApprovalId> getType() {
		return ApprovalId.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("approvalIdScheme"), String.class, getApprovalIdScheme(), this);
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ApprovalIdBuilder extends ApprovalId, RosettaModelObjectBuilder {
		ApprovalId.ApprovalIdBuilder setValue(String value);
		ApprovalId.ApprovalIdBuilder setApprovalIdScheme(String approvalIdScheme);
		ApprovalId.ApprovalIdBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("approvalIdScheme"), String.class, getApprovalIdScheme(), this);
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		ApprovalId.ApprovalIdBuilder prune();
	}

	/*********************** Immutable Implementation of ApprovalId  ***********************/
	class ApprovalIdImpl implements ApprovalId {
		private final String value;
		private final String approvalIdScheme;
		private final String id;
		
		protected ApprovalIdImpl(ApprovalId.ApprovalIdBuilder builder) {
			this.value = builder.getValue();
			this.approvalIdScheme = builder.getApprovalIdScheme();
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("approvalIdScheme")
		public String getApprovalIdScheme() {
			return approvalIdScheme;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public ApprovalId build() {
			return this;
		}
		
		@Override
		public ApprovalId.ApprovalIdBuilder toBuilder() {
			ApprovalId.ApprovalIdBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ApprovalId.ApprovalIdBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getApprovalIdScheme()).ifPresent(builder::setApprovalIdScheme);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ApprovalId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(approvalIdScheme, _that.getApprovalIdScheme())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (approvalIdScheme != null ? approvalIdScheme.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ApprovalId {" +
				"value=" + this.value + ", " +
				"approvalIdScheme=" + this.approvalIdScheme + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of ApprovalId  ***********************/
	class ApprovalIdBuilderImpl implements ApprovalId.ApprovalIdBuilder {
	
		protected String value;
		protected String approvalIdScheme;
		protected String id;
	
		public ApprovalIdBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("approvalIdScheme")
		public String getApprovalIdScheme() {
			return approvalIdScheme;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("value")
		public ApprovalId.ApprovalIdBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("approvalIdScheme")
		public ApprovalId.ApprovalIdBuilder setApprovalIdScheme(String approvalIdScheme) {
			this.approvalIdScheme = approvalIdScheme==null?null:approvalIdScheme;
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public ApprovalId.ApprovalIdBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public ApprovalId build() {
			return new ApprovalId.ApprovalIdImpl(this);
		}
		
		@Override
		public ApprovalId.ApprovalIdBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ApprovalId.ApprovalIdBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getApprovalIdScheme()!=null) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ApprovalId.ApprovalIdBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ApprovalId.ApprovalIdBuilder o = (ApprovalId.ApprovalIdBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getApprovalIdScheme(), o.getApprovalIdScheme(), this::setApprovalIdScheme);
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ApprovalId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(approvalIdScheme, _that.getApprovalIdScheme())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (approvalIdScheme != null ? approvalIdScheme.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ApprovalIdBuilder {" +
				"value=" + this.value + ", " +
				"approvalIdScheme=" + this.approvalIdScheme + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
