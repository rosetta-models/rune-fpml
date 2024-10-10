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
import fpml.confirmation.CorrelationId;
import fpml.confirmation.CorrelationId.CorrelationIdBuilder;
import fpml.confirmation.CorrelationId.CorrelationIdBuilderImpl;
import fpml.confirmation.CorrelationId.CorrelationIdImpl;
import fpml.confirmation.meta.CorrelationIdMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type defining a correlation identifier and qualifying scheme
 * @version ${project.version}
 */
@RosettaDataType(value="CorrelationId", builder=CorrelationId.CorrelationIdBuilderImpl.class, version="${project.version}")
public interface CorrelationId extends RosettaModelObject {

	CorrelationIdMeta metaData = new CorrelationIdMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getCorrelationIdScheme();

	/*********************** Build Methods  ***********************/
	CorrelationId build();
	
	CorrelationId.CorrelationIdBuilder toBuilder();
	
	static CorrelationId.CorrelationIdBuilder builder() {
		return new CorrelationId.CorrelationIdBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CorrelationId> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CorrelationId> getType() {
		return CorrelationId.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("correlationIdScheme"), String.class, getCorrelationIdScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CorrelationIdBuilder extends CorrelationId, RosettaModelObjectBuilder {
		CorrelationId.CorrelationIdBuilder setValue(String value);
		CorrelationId.CorrelationIdBuilder setCorrelationIdScheme(String correlationIdScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("correlationIdScheme"), String.class, getCorrelationIdScheme(), this);
		}
		

		CorrelationId.CorrelationIdBuilder prune();
	}

	/*********************** Immutable Implementation of CorrelationId  ***********************/
	class CorrelationIdImpl implements CorrelationId {
		private final String value;
		private final String correlationIdScheme;
		
		protected CorrelationIdImpl(CorrelationId.CorrelationIdBuilder builder) {
			this.value = builder.getValue();
			this.correlationIdScheme = builder.getCorrelationIdScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("correlationIdScheme")
		public String getCorrelationIdScheme() {
			return correlationIdScheme;
		}
		
		@Override
		public CorrelationId build() {
			return this;
		}
		
		@Override
		public CorrelationId.CorrelationIdBuilder toBuilder() {
			CorrelationId.CorrelationIdBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CorrelationId.CorrelationIdBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getCorrelationIdScheme()).ifPresent(builder::setCorrelationIdScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CorrelationId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(correlationIdScheme, _that.getCorrelationIdScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (correlationIdScheme != null ? correlationIdScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CorrelationId {" +
				"value=" + this.value + ", " +
				"correlationIdScheme=" + this.correlationIdScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of CorrelationId  ***********************/
	class CorrelationIdBuilderImpl implements CorrelationId.CorrelationIdBuilder {
	
		protected String value;
		protected String correlationIdScheme;
	
		public CorrelationIdBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("correlationIdScheme")
		public String getCorrelationIdScheme() {
			return correlationIdScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public CorrelationId.CorrelationIdBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("correlationIdScheme")
		public CorrelationId.CorrelationIdBuilder setCorrelationIdScheme(String correlationIdScheme) {
			this.correlationIdScheme = correlationIdScheme==null?null:correlationIdScheme;
			return this;
		}
		
		@Override
		public CorrelationId build() {
			return new CorrelationId.CorrelationIdImpl(this);
		}
		
		@Override
		public CorrelationId.CorrelationIdBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CorrelationId.CorrelationIdBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getCorrelationIdScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CorrelationId.CorrelationIdBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CorrelationId.CorrelationIdBuilder o = (CorrelationId.CorrelationIdBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getCorrelationIdScheme(), o.getCorrelationIdScheme(), this::setCorrelationIdScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CorrelationId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(correlationIdScheme, _that.getCorrelationIdScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (correlationIdScheme != null ? correlationIdScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CorrelationIdBuilder {" +
				"value=" + this.value + ", " +
				"correlationIdScheme=" + this.correlationIdScheme +
			'}';
		}
	}
}
