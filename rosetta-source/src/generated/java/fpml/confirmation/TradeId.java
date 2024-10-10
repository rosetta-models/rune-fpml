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
import fpml.confirmation.TradeId;
import fpml.confirmation.TradeId.TradeIdBuilder;
import fpml.confirmation.TradeId.TradeIdBuilderImpl;
import fpml.confirmation.TradeId.TradeIdImpl;
import fpml.confirmation.meta.TradeIdMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A trade reference identifier allocated by a party. FpML does not define the domain values associated with this element. Note that the domain values for this element are not strictly an enumerated list.
 * @version ${project.version}
 */
@RosettaDataType(value="TradeId", builder=TradeId.TradeIdBuilderImpl.class, version="${project.version}")
public interface TradeId extends RosettaModelObject {

	TradeIdMeta metaData = new TradeIdMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getTradeIdScheme();
	String getId();

	/*********************** Build Methods  ***********************/
	TradeId build();
	
	TradeId.TradeIdBuilder toBuilder();
	
	static TradeId.TradeIdBuilder builder() {
		return new TradeId.TradeIdBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeId> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends TradeId> getType() {
		return TradeId.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("tradeIdScheme"), String.class, getTradeIdScheme(), this);
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeIdBuilder extends TradeId, RosettaModelObjectBuilder {
		TradeId.TradeIdBuilder setValue(String value);
		TradeId.TradeIdBuilder setTradeIdScheme(String tradeIdScheme);
		TradeId.TradeIdBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("tradeIdScheme"), String.class, getTradeIdScheme(), this);
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		TradeId.TradeIdBuilder prune();
	}

	/*********************** Immutable Implementation of TradeId  ***********************/
	class TradeIdImpl implements TradeId {
		private final String value;
		private final String tradeIdScheme;
		private final String id;
		
		protected TradeIdImpl(TradeId.TradeIdBuilder builder) {
			this.value = builder.getValue();
			this.tradeIdScheme = builder.getTradeIdScheme();
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("tradeIdScheme")
		public String getTradeIdScheme() {
			return tradeIdScheme;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public TradeId build() {
			return this;
		}
		
		@Override
		public TradeId.TradeIdBuilder toBuilder() {
			TradeId.TradeIdBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeId.TradeIdBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getTradeIdScheme()).ifPresent(builder::setTradeIdScheme);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(tradeIdScheme, _that.getTradeIdScheme())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (tradeIdScheme != null ? tradeIdScheme.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeId {" +
				"value=" + this.value + ", " +
				"tradeIdScheme=" + this.tradeIdScheme + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of TradeId  ***********************/
	class TradeIdBuilderImpl implements TradeId.TradeIdBuilder {
	
		protected String value;
		protected String tradeIdScheme;
		protected String id;
	
		public TradeIdBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("tradeIdScheme")
		public String getTradeIdScheme() {
			return tradeIdScheme;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("value")
		public TradeId.TradeIdBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("tradeIdScheme")
		public TradeId.TradeIdBuilder setTradeIdScheme(String tradeIdScheme) {
			this.tradeIdScheme = tradeIdScheme==null?null:tradeIdScheme;
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public TradeId.TradeIdBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public TradeId build() {
			return new TradeId.TradeIdImpl(this);
		}
		
		@Override
		public TradeId.TradeIdBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeId.TradeIdBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getTradeIdScheme()!=null) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeId.TradeIdBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TradeId.TradeIdBuilder o = (TradeId.TradeIdBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getTradeIdScheme(), o.getTradeIdScheme(), this::setTradeIdScheme);
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(tradeIdScheme, _that.getTradeIdScheme())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (tradeIdScheme != null ? tradeIdScheme.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeIdBuilder {" +
				"value=" + this.value + ", " +
				"tradeIdScheme=" + this.tradeIdScheme + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
