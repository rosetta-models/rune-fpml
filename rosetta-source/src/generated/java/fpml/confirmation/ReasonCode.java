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
import fpml.confirmation.ReasonCode;
import fpml.confirmation.ReasonCode.ReasonCodeBuilder;
import fpml.confirmation.ReasonCode.ReasonCodeBuilderImpl;
import fpml.confirmation.ReasonCode.ReasonCodeImpl;
import fpml.confirmation.meta.ReasonCodeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Defines a list of machine interpretable error codes.
 * @version ${project.version}
 */
@RosettaDataType(value="ReasonCode", builder=ReasonCode.ReasonCodeBuilderImpl.class, version="${project.version}")
public interface ReasonCode extends RosettaModelObject {

	ReasonCodeMeta metaData = new ReasonCodeMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getReasonCodeScheme();

	/*********************** Build Methods  ***********************/
	ReasonCode build();
	
	ReasonCode.ReasonCodeBuilder toBuilder();
	
	static ReasonCode.ReasonCodeBuilder builder() {
		return new ReasonCode.ReasonCodeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ReasonCode> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ReasonCode> getType() {
		return ReasonCode.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("reasonCodeScheme"), String.class, getReasonCodeScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ReasonCodeBuilder extends ReasonCode, RosettaModelObjectBuilder {
		ReasonCode.ReasonCodeBuilder setValue(String value);
		ReasonCode.ReasonCodeBuilder setReasonCodeScheme(String reasonCodeScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("reasonCodeScheme"), String.class, getReasonCodeScheme(), this);
		}
		

		ReasonCode.ReasonCodeBuilder prune();
	}

	/*********************** Immutable Implementation of ReasonCode  ***********************/
	class ReasonCodeImpl implements ReasonCode {
		private final String value;
		private final String reasonCodeScheme;
		
		protected ReasonCodeImpl(ReasonCode.ReasonCodeBuilder builder) {
			this.value = builder.getValue();
			this.reasonCodeScheme = builder.getReasonCodeScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("reasonCodeScheme")
		public String getReasonCodeScheme() {
			return reasonCodeScheme;
		}
		
		@Override
		public ReasonCode build() {
			return this;
		}
		
		@Override
		public ReasonCode.ReasonCodeBuilder toBuilder() {
			ReasonCode.ReasonCodeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReasonCode.ReasonCodeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getReasonCodeScheme()).ifPresent(builder::setReasonCodeScheme);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReasonCode _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(reasonCodeScheme, _that.getReasonCodeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (reasonCodeScheme != null ? reasonCodeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReasonCode {" +
				"value=" + this.value + ", " +
				"reasonCodeScheme=" + this.reasonCodeScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of ReasonCode  ***********************/
	class ReasonCodeBuilderImpl implements ReasonCode.ReasonCodeBuilder {
	
		protected String value;
		protected String reasonCodeScheme;
	
		public ReasonCodeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("reasonCodeScheme")
		public String getReasonCodeScheme() {
			return reasonCodeScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public ReasonCode.ReasonCodeBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("reasonCodeScheme")
		public ReasonCode.ReasonCodeBuilder setReasonCodeScheme(String reasonCodeScheme) {
			this.reasonCodeScheme = reasonCodeScheme==null?null:reasonCodeScheme;
			return this;
		}
		
		@Override
		public ReasonCode build() {
			return new ReasonCode.ReasonCodeImpl(this);
		}
		
		@Override
		public ReasonCode.ReasonCodeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReasonCode.ReasonCodeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getReasonCodeScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReasonCode.ReasonCodeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ReasonCode.ReasonCodeBuilder o = (ReasonCode.ReasonCodeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getReasonCodeScheme(), o.getReasonCodeScheme(), this::setReasonCodeScheme);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReasonCode _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(reasonCodeScheme, _that.getReasonCodeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (reasonCodeScheme != null ? reasonCodeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReasonCodeBuilder {" +
				"value=" + this.value + ", " +
				"reasonCodeScheme=" + this.reasonCodeScheme +
			'}';
		}
	}
}
