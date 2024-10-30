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
import fpml.confirmation.TerminatingEvent;
import fpml.confirmation.TerminatingEvent.TerminatingEventBuilder;
import fpml.confirmation.TerminatingEvent.TerminatingEventBuilderImpl;
import fpml.confirmation.TerminatingEvent.TerminatingEventImpl;
import fpml.confirmation.meta.TerminatingEventMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type that describes why a trade terminated.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="TerminatingEvent", builder=TerminatingEvent.TerminatingEventBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface TerminatingEvent extends RosettaModelObject {

	TerminatingEventMeta metaData = new TerminatingEventMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getTerminatingEventScheme();

	/*********************** Build Methods  ***********************/
	TerminatingEvent build();
	
	TerminatingEvent.TerminatingEventBuilder toBuilder();
	
	static TerminatingEvent.TerminatingEventBuilder builder() {
		return new TerminatingEvent.TerminatingEventBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TerminatingEvent> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends TerminatingEvent> getType() {
		return TerminatingEvent.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("terminatingEventScheme"), String.class, getTerminatingEventScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface TerminatingEventBuilder extends TerminatingEvent, RosettaModelObjectBuilder {
		TerminatingEvent.TerminatingEventBuilder setValue(String value);
		TerminatingEvent.TerminatingEventBuilder setTerminatingEventScheme(String terminatingEventScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("terminatingEventScheme"), String.class, getTerminatingEventScheme(), this);
		}
		

		TerminatingEvent.TerminatingEventBuilder prune();
	}

	/*********************** Immutable Implementation of TerminatingEvent  ***********************/
	class TerminatingEventImpl implements TerminatingEvent {
		private final String value;
		private final String terminatingEventScheme;
		
		protected TerminatingEventImpl(TerminatingEvent.TerminatingEventBuilder builder) {
			this.value = builder.getValue();
			this.terminatingEventScheme = builder.getTerminatingEventScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("terminatingEventScheme")
		public String getTerminatingEventScheme() {
			return terminatingEventScheme;
		}
		
		@Override
		public TerminatingEvent build() {
			return this;
		}
		
		@Override
		public TerminatingEvent.TerminatingEventBuilder toBuilder() {
			TerminatingEvent.TerminatingEventBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TerminatingEvent.TerminatingEventBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getTerminatingEventScheme()).ifPresent(builder::setTerminatingEventScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TerminatingEvent _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(terminatingEventScheme, _that.getTerminatingEventScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (terminatingEventScheme != null ? terminatingEventScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TerminatingEvent {" +
				"value=" + this.value + ", " +
				"terminatingEventScheme=" + this.terminatingEventScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of TerminatingEvent  ***********************/
	class TerminatingEventBuilderImpl implements TerminatingEvent.TerminatingEventBuilder {
	
		protected String value;
		protected String terminatingEventScheme;
	
		public TerminatingEventBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("terminatingEventScheme")
		public String getTerminatingEventScheme() {
			return terminatingEventScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public TerminatingEvent.TerminatingEventBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("terminatingEventScheme")
		public TerminatingEvent.TerminatingEventBuilder setTerminatingEventScheme(String terminatingEventScheme) {
			this.terminatingEventScheme = terminatingEventScheme==null?null:terminatingEventScheme;
			return this;
		}
		
		@Override
		public TerminatingEvent build() {
			return new TerminatingEvent.TerminatingEventImpl(this);
		}
		
		@Override
		public TerminatingEvent.TerminatingEventBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TerminatingEvent.TerminatingEventBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getTerminatingEventScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TerminatingEvent.TerminatingEventBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TerminatingEvent.TerminatingEventBuilder o = (TerminatingEvent.TerminatingEventBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getTerminatingEventScheme(), o.getTerminatingEventScheme(), this::setTerminatingEventScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TerminatingEvent _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(terminatingEventScheme, _that.getTerminatingEventScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (terminatingEventScheme != null ? terminatingEventScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TerminatingEventBuilder {" +
				"value=" + this.value + ", " +
				"terminatingEventScheme=" + this.terminatingEventScheme +
			'}';
		}
	}
}
