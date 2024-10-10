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
import fpml.confirmation.TradingWaiver;
import fpml.confirmation.TradingWaiver.TradingWaiverBuilder;
import fpml.confirmation.TradingWaiver.TradingWaiverBuilderImpl;
import fpml.confirmation.TradingWaiver.TradingWaiverImpl;
import fpml.confirmation.meta.TradingWaiverMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Indication as to whether the transaction was executed under a pre-trade waiver in accordance with Articles 4 and 9 of Regulation (EU) 600/2014.
 * @version ${project.version}
 */
@RosettaDataType(value="TradingWaiver", builder=TradingWaiver.TradingWaiverBuilderImpl.class, version="${project.version}")
public interface TradingWaiver extends RosettaModelObject {

	TradingWaiverMeta metaData = new TradingWaiverMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getTradingWaiverScheme();

	/*********************** Build Methods  ***********************/
	TradingWaiver build();
	
	TradingWaiver.TradingWaiverBuilder toBuilder();
	
	static TradingWaiver.TradingWaiverBuilder builder() {
		return new TradingWaiver.TradingWaiverBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradingWaiver> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends TradingWaiver> getType() {
		return TradingWaiver.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("tradingWaiverScheme"), String.class, getTradingWaiverScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradingWaiverBuilder extends TradingWaiver, RosettaModelObjectBuilder {
		TradingWaiver.TradingWaiverBuilder setValue(String value);
		TradingWaiver.TradingWaiverBuilder setTradingWaiverScheme(String tradingWaiverScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("tradingWaiverScheme"), String.class, getTradingWaiverScheme(), this);
		}
		

		TradingWaiver.TradingWaiverBuilder prune();
	}

	/*********************** Immutable Implementation of TradingWaiver  ***********************/
	class TradingWaiverImpl implements TradingWaiver {
		private final String value;
		private final String tradingWaiverScheme;
		
		protected TradingWaiverImpl(TradingWaiver.TradingWaiverBuilder builder) {
			this.value = builder.getValue();
			this.tradingWaiverScheme = builder.getTradingWaiverScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("tradingWaiverScheme")
		public String getTradingWaiverScheme() {
			return tradingWaiverScheme;
		}
		
		@Override
		public TradingWaiver build() {
			return this;
		}
		
		@Override
		public TradingWaiver.TradingWaiverBuilder toBuilder() {
			TradingWaiver.TradingWaiverBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradingWaiver.TradingWaiverBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getTradingWaiverScheme()).ifPresent(builder::setTradingWaiverScheme);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradingWaiver _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(tradingWaiverScheme, _that.getTradingWaiverScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (tradingWaiverScheme != null ? tradingWaiverScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradingWaiver {" +
				"value=" + this.value + ", " +
				"tradingWaiverScheme=" + this.tradingWaiverScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of TradingWaiver  ***********************/
	class TradingWaiverBuilderImpl implements TradingWaiver.TradingWaiverBuilder {
	
		protected String value;
		protected String tradingWaiverScheme;
	
		public TradingWaiverBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("tradingWaiverScheme")
		public String getTradingWaiverScheme() {
			return tradingWaiverScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public TradingWaiver.TradingWaiverBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("tradingWaiverScheme")
		public TradingWaiver.TradingWaiverBuilder setTradingWaiverScheme(String tradingWaiverScheme) {
			this.tradingWaiverScheme = tradingWaiverScheme==null?null:tradingWaiverScheme;
			return this;
		}
		
		@Override
		public TradingWaiver build() {
			return new TradingWaiver.TradingWaiverImpl(this);
		}
		
		@Override
		public TradingWaiver.TradingWaiverBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradingWaiver.TradingWaiverBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getTradingWaiverScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradingWaiver.TradingWaiverBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TradingWaiver.TradingWaiverBuilder o = (TradingWaiver.TradingWaiverBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getTradingWaiverScheme(), o.getTradingWaiverScheme(), this::setTradingWaiverScheme);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradingWaiver _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(tradingWaiverScheme, _that.getTradingWaiverScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (tradingWaiverScheme != null ? tradingWaiverScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradingWaiverBuilder {" +
				"value=" + this.value + ", " +
				"tradingWaiverScheme=" + this.tradingWaiverScheme +
			'}';
		}
	}
}
