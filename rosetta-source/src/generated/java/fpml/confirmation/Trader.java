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
import fpml.confirmation.Trader;
import fpml.confirmation.Trader.TraderBuilder;
import fpml.confirmation.Trader.TraderBuilderImpl;
import fpml.confirmation.Trader.TraderImpl;
import fpml.confirmation.meta.TraderMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="Trader", builder=Trader.TraderBuilderImpl.class, version="${project.version}")
public interface Trader extends RosettaModelObject {

	TraderMeta metaData = new TraderMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getTraderScheme();

	/*********************** Build Methods  ***********************/
	Trader build();
	
	Trader.TraderBuilder toBuilder();
	
	static Trader.TraderBuilder builder() {
		return new Trader.TraderBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Trader> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends Trader> getType() {
		return Trader.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("traderScheme"), String.class, getTraderScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface TraderBuilder extends Trader, RosettaModelObjectBuilder {
		Trader.TraderBuilder setValue(String value);
		Trader.TraderBuilder setTraderScheme(String traderScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("traderScheme"), String.class, getTraderScheme(), this);
		}
		

		Trader.TraderBuilder prune();
	}

	/*********************** Immutable Implementation of Trader  ***********************/
	class TraderImpl implements Trader {
		private final String value;
		private final String traderScheme;
		
		protected TraderImpl(Trader.TraderBuilder builder) {
			this.value = builder.getValue();
			this.traderScheme = builder.getTraderScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("traderScheme")
		public String getTraderScheme() {
			return traderScheme;
		}
		
		@Override
		public Trader build() {
			return this;
		}
		
		@Override
		public Trader.TraderBuilder toBuilder() {
			Trader.TraderBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Trader.TraderBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getTraderScheme()).ifPresent(builder::setTraderScheme);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Trader _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(traderScheme, _that.getTraderScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (traderScheme != null ? traderScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Trader {" +
				"value=" + this.value + ", " +
				"traderScheme=" + this.traderScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of Trader  ***********************/
	class TraderBuilderImpl implements Trader.TraderBuilder {
	
		protected String value;
		protected String traderScheme;
	
		public TraderBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("traderScheme")
		public String getTraderScheme() {
			return traderScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public Trader.TraderBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("traderScheme")
		public Trader.TraderBuilder setTraderScheme(String traderScheme) {
			this.traderScheme = traderScheme==null?null:traderScheme;
			return this;
		}
		
		@Override
		public Trader build() {
			return new Trader.TraderImpl(this);
		}
		
		@Override
		public Trader.TraderBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Trader.TraderBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getTraderScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Trader.TraderBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Trader.TraderBuilder o = (Trader.TraderBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getTraderScheme(), o.getTraderScheme(), this::setTraderScheme);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Trader _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(traderScheme, _that.getTraderScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (traderScheme != null ? traderScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TraderBuilder {" +
				"value=" + this.value + ", " +
				"traderScheme=" + this.traderScheme +
			'}';
		}
	}
}
