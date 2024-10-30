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
import fpml.confirmation.TimestampTypeScheme;
import fpml.confirmation.TradeTimestamp;
import fpml.confirmation.TradeTimestamp.TradeTimestampBuilder;
import fpml.confirmation.TradeTimestamp.TradeTimestampBuilderImpl;
import fpml.confirmation.TradeTimestamp.TradeTimestampImpl;
import fpml.confirmation.meta.TradeTimestampMeta;
import java.time.ZonedDateTime;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A generic trade timestamp
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="TradeTimestamp", builder=TradeTimestamp.TradeTimestampBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface TradeTimestamp extends RosettaModelObject {

	TradeTimestampMeta metaData = new TradeTimestampMeta();

	/*********************** Getter Methods  ***********************/
	TimestampTypeScheme get_type();
	ZonedDateTime getValue();

	/*********************** Build Methods  ***********************/
	TradeTimestamp build();
	
	TradeTimestamp.TradeTimestampBuilder toBuilder();
	
	static TradeTimestamp.TradeTimestampBuilder builder() {
		return new TradeTimestamp.TradeTimestampBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeTimestamp> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends TradeTimestamp> getType() {
		return TradeTimestamp.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("_type"), processor, TimestampTypeScheme.class, get_type());
		processor.processBasic(path.newSubPath("value"), ZonedDateTime.class, getValue(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeTimestampBuilder extends TradeTimestamp, RosettaModelObjectBuilder {
		TimestampTypeScheme.TimestampTypeSchemeBuilder getOrCreate_type();
		TimestampTypeScheme.TimestampTypeSchemeBuilder get_type();
		TradeTimestamp.TradeTimestampBuilder set_type(TimestampTypeScheme _type);
		TradeTimestamp.TradeTimestampBuilder setValue(ZonedDateTime value);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("_type"), processor, TimestampTypeScheme.TimestampTypeSchemeBuilder.class, get_type());
			processor.processBasic(path.newSubPath("value"), ZonedDateTime.class, getValue(), this);
		}
		

		TradeTimestamp.TradeTimestampBuilder prune();
	}

	/*********************** Immutable Implementation of TradeTimestamp  ***********************/
	class TradeTimestampImpl implements TradeTimestamp {
		private final TimestampTypeScheme _type;
		private final ZonedDateTime value;
		
		protected TradeTimestampImpl(TradeTimestamp.TradeTimestampBuilder builder) {
			this._type = ofNullable(builder.get_type()).map(f->f.build()).orElse(null);
			this.value = builder.getValue();
		}
		
		@Override
		@RosettaAttribute("_type")
		public TimestampTypeScheme get_type() {
			return _type;
		}
		
		@Override
		@RosettaAttribute("value")
		public ZonedDateTime getValue() {
			return value;
		}
		
		@Override
		public TradeTimestamp build() {
			return this;
		}
		
		@Override
		public TradeTimestamp.TradeTimestampBuilder toBuilder() {
			TradeTimestamp.TradeTimestampBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeTimestamp.TradeTimestampBuilder builder) {
			ofNullable(get_type()).ifPresent(builder::set_type);
			ofNullable(getValue()).ifPresent(builder::setValue);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeTimestamp _that = getType().cast(o);
		
			if (!Objects.equals(_type, _that.get_type())) return false;
			if (!Objects.equals(value, _that.getValue())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (_type != null ? _type.hashCode() : 0);
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeTimestamp {" +
				"_type=" + this._type + ", " +
				"value=" + this.value +
			'}';
		}
	}

	/*********************** Builder Implementation of TradeTimestamp  ***********************/
	class TradeTimestampBuilderImpl implements TradeTimestamp.TradeTimestampBuilder {
	
		protected TimestampTypeScheme.TimestampTypeSchemeBuilder _type;
		protected ZonedDateTime value;
	
		public TradeTimestampBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("_type")
		public TimestampTypeScheme.TimestampTypeSchemeBuilder get_type() {
			return _type;
		}
		
		@Override
		public TimestampTypeScheme.TimestampTypeSchemeBuilder getOrCreate_type() {
			TimestampTypeScheme.TimestampTypeSchemeBuilder result;
			if (_type!=null) {
				result = _type;
			}
			else {
				result = _type = TimestampTypeScheme.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("value")
		public ZonedDateTime getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("_type")
		public TradeTimestamp.TradeTimestampBuilder set_type(TimestampTypeScheme _type) {
			this._type = _type==null?null:_type.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("value")
		public TradeTimestamp.TradeTimestampBuilder setValue(ZonedDateTime value) {
			this.value = value==null?null:value;
			return this;
		}
		
		@Override
		public TradeTimestamp build() {
			return new TradeTimestamp.TradeTimestampImpl(this);
		}
		
		@Override
		public TradeTimestamp.TradeTimestampBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeTimestamp.TradeTimestampBuilder prune() {
			if (_type!=null && !_type.prune().hasData()) _type = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (get_type()!=null && get_type().hasData()) return true;
			if (getValue()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeTimestamp.TradeTimestampBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TradeTimestamp.TradeTimestampBuilder o = (TradeTimestamp.TradeTimestampBuilder) other;
			
			merger.mergeRosetta(get_type(), o.get_type(), this::set_type);
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeTimestamp _that = getType().cast(o);
		
			if (!Objects.equals(_type, _that.get_type())) return false;
			if (!Objects.equals(value, _that.getValue())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (_type != null ? _type.hashCode() : 0);
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeTimestampBuilder {" +
				"_type=" + this._type + ", " +
				"value=" + this.value +
			'}';
		}
	}
}
