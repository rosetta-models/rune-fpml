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
import fpml.confirmation.InstrumentId;
import fpml.confirmation.InstrumentId.InstrumentIdBuilder;
import fpml.confirmation.InstrumentId.InstrumentIdBuilderImpl;
import fpml.confirmation.InstrumentId.InstrumentIdImpl;
import fpml.confirmation.meta.InstrumentIdMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A short form unique identifier for a security.
 * @version ${project.version}
 */
@RosettaDataType(value="InstrumentId", builder=InstrumentId.InstrumentIdBuilderImpl.class, version="${project.version}")
public interface InstrumentId extends RosettaModelObject {

	InstrumentIdMeta metaData = new InstrumentIdMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getInstrumentIdScheme();

	/*********************** Build Methods  ***********************/
	InstrumentId build();
	
	InstrumentId.InstrumentIdBuilder toBuilder();
	
	static InstrumentId.InstrumentIdBuilder builder() {
		return new InstrumentId.InstrumentIdBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends InstrumentId> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends InstrumentId> getType() {
		return InstrumentId.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("instrumentIdScheme"), String.class, getInstrumentIdScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface InstrumentIdBuilder extends InstrumentId, RosettaModelObjectBuilder {
		InstrumentId.InstrumentIdBuilder setValue(String value);
		InstrumentId.InstrumentIdBuilder setInstrumentIdScheme(String instrumentIdScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("instrumentIdScheme"), String.class, getInstrumentIdScheme(), this);
		}
		

		InstrumentId.InstrumentIdBuilder prune();
	}

	/*********************** Immutable Implementation of InstrumentId  ***********************/
	class InstrumentIdImpl implements InstrumentId {
		private final String value;
		private final String instrumentIdScheme;
		
		protected InstrumentIdImpl(InstrumentId.InstrumentIdBuilder builder) {
			this.value = builder.getValue();
			this.instrumentIdScheme = builder.getInstrumentIdScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("instrumentIdScheme")
		public String getInstrumentIdScheme() {
			return instrumentIdScheme;
		}
		
		@Override
		public InstrumentId build() {
			return this;
		}
		
		@Override
		public InstrumentId.InstrumentIdBuilder toBuilder() {
			InstrumentId.InstrumentIdBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(InstrumentId.InstrumentIdBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getInstrumentIdScheme()).ifPresent(builder::setInstrumentIdScheme);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			InstrumentId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(instrumentIdScheme, _that.getInstrumentIdScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (instrumentIdScheme != null ? instrumentIdScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InstrumentId {" +
				"value=" + this.value + ", " +
				"instrumentIdScheme=" + this.instrumentIdScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of InstrumentId  ***********************/
	class InstrumentIdBuilderImpl implements InstrumentId.InstrumentIdBuilder {
	
		protected String value;
		protected String instrumentIdScheme;
	
		public InstrumentIdBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("instrumentIdScheme")
		public String getInstrumentIdScheme() {
			return instrumentIdScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public InstrumentId.InstrumentIdBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("instrumentIdScheme")
		public InstrumentId.InstrumentIdBuilder setInstrumentIdScheme(String instrumentIdScheme) {
			this.instrumentIdScheme = instrumentIdScheme==null?null:instrumentIdScheme;
			return this;
		}
		
		@Override
		public InstrumentId build() {
			return new InstrumentId.InstrumentIdImpl(this);
		}
		
		@Override
		public InstrumentId.InstrumentIdBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InstrumentId.InstrumentIdBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getInstrumentIdScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InstrumentId.InstrumentIdBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			InstrumentId.InstrumentIdBuilder o = (InstrumentId.InstrumentIdBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getInstrumentIdScheme(), o.getInstrumentIdScheme(), this::setInstrumentIdScheme);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			InstrumentId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(instrumentIdScheme, _that.getInstrumentIdScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (instrumentIdScheme != null ? instrumentIdScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InstrumentIdBuilder {" +
				"value=" + this.value + ", " +
				"instrumentIdScheme=" + this.instrumentIdScheme +
			'}';
		}
	}
}
