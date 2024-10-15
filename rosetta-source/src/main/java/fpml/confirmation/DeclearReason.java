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
import fpml.confirmation.DeclearReason;
import fpml.confirmation.DeclearReason.DeclearReasonBuilder;
import fpml.confirmation.DeclearReason.DeclearReasonBuilderImpl;
import fpml.confirmation.DeclearReason.DeclearReasonImpl;
import fpml.confirmation.meta.DeclearReasonMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type that describes why a trade was removed from clearing.
 * @version ${project.version}
 */
@RosettaDataType(value="DeclearReason", builder=DeclearReason.DeclearReasonBuilderImpl.class, version="${project.version}")
public interface DeclearReason extends RosettaModelObject {

	DeclearReasonMeta metaData = new DeclearReasonMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getDeclearReasonScheme();

	/*********************** Build Methods  ***********************/
	DeclearReason build();
	
	DeclearReason.DeclearReasonBuilder toBuilder();
	
	static DeclearReason.DeclearReasonBuilder builder() {
		return new DeclearReason.DeclearReasonBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DeclearReason> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends DeclearReason> getType() {
		return DeclearReason.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("declearReasonScheme"), String.class, getDeclearReasonScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface DeclearReasonBuilder extends DeclearReason, RosettaModelObjectBuilder {
		DeclearReason.DeclearReasonBuilder setValue(String value);
		DeclearReason.DeclearReasonBuilder setDeclearReasonScheme(String declearReasonScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("declearReasonScheme"), String.class, getDeclearReasonScheme(), this);
		}
		

		DeclearReason.DeclearReasonBuilder prune();
	}

	/*********************** Immutable Implementation of DeclearReason  ***********************/
	class DeclearReasonImpl implements DeclearReason {
		private final String value;
		private final String declearReasonScheme;
		
		protected DeclearReasonImpl(DeclearReason.DeclearReasonBuilder builder) {
			this.value = builder.getValue();
			this.declearReasonScheme = builder.getDeclearReasonScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("declearReasonScheme")
		public String getDeclearReasonScheme() {
			return declearReasonScheme;
		}
		
		@Override
		public DeclearReason build() {
			return this;
		}
		
		@Override
		public DeclearReason.DeclearReasonBuilder toBuilder() {
			DeclearReason.DeclearReasonBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DeclearReason.DeclearReasonBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getDeclearReasonScheme()).ifPresent(builder::setDeclearReasonScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DeclearReason _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(declearReasonScheme, _that.getDeclearReasonScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (declearReasonScheme != null ? declearReasonScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DeclearReason {" +
				"value=" + this.value + ", " +
				"declearReasonScheme=" + this.declearReasonScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of DeclearReason  ***********************/
	class DeclearReasonBuilderImpl implements DeclearReason.DeclearReasonBuilder {
	
		protected String value;
		protected String declearReasonScheme;
	
		public DeclearReasonBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("declearReasonScheme")
		public String getDeclearReasonScheme() {
			return declearReasonScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public DeclearReason.DeclearReasonBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("declearReasonScheme")
		public DeclearReason.DeclearReasonBuilder setDeclearReasonScheme(String declearReasonScheme) {
			this.declearReasonScheme = declearReasonScheme==null?null:declearReasonScheme;
			return this;
		}
		
		@Override
		public DeclearReason build() {
			return new DeclearReason.DeclearReasonImpl(this);
		}
		
		@Override
		public DeclearReason.DeclearReasonBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DeclearReason.DeclearReasonBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getDeclearReasonScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DeclearReason.DeclearReasonBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DeclearReason.DeclearReasonBuilder o = (DeclearReason.DeclearReasonBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getDeclearReasonScheme(), o.getDeclearReasonScheme(), this::setDeclearReasonScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DeclearReason _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(declearReasonScheme, _that.getDeclearReasonScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (declearReasonScheme != null ? declearReasonScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DeclearReasonBuilder {" +
				"value=" + this.value + ", " +
				"declearReasonScheme=" + this.declearReasonScheme +
			'}';
		}
	}
}
