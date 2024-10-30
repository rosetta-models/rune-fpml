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
import fpml.confirmation.BullionDeliveryLocation;
import fpml.confirmation.BullionDeliveryLocation.BullionDeliveryLocationBuilder;
import fpml.confirmation.BullionDeliveryLocation.BullionDeliveryLocationBuilderImpl;
import fpml.confirmation.BullionDeliveryLocation.BullionDeliveryLocationImpl;
import fpml.confirmation.meta.BullionDeliveryLocationMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A scheme defining where bullion is to be delivered for a Bullion Transaction.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="BullionDeliveryLocation", builder=BullionDeliveryLocation.BullionDeliveryLocationBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface BullionDeliveryLocation extends RosettaModelObject {

	BullionDeliveryLocationMeta metaData = new BullionDeliveryLocationMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getBullionDeliveryLocationScheme();

	/*********************** Build Methods  ***********************/
	BullionDeliveryLocation build();
	
	BullionDeliveryLocation.BullionDeliveryLocationBuilder toBuilder();
	
	static BullionDeliveryLocation.BullionDeliveryLocationBuilder builder() {
		return new BullionDeliveryLocation.BullionDeliveryLocationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends BullionDeliveryLocation> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends BullionDeliveryLocation> getType() {
		return BullionDeliveryLocation.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("bullionDeliveryLocationScheme"), String.class, getBullionDeliveryLocationScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface BullionDeliveryLocationBuilder extends BullionDeliveryLocation, RosettaModelObjectBuilder {
		BullionDeliveryLocation.BullionDeliveryLocationBuilder setValue(String value);
		BullionDeliveryLocation.BullionDeliveryLocationBuilder setBullionDeliveryLocationScheme(String bullionDeliveryLocationScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("bullionDeliveryLocationScheme"), String.class, getBullionDeliveryLocationScheme(), this);
		}
		

		BullionDeliveryLocation.BullionDeliveryLocationBuilder prune();
	}

	/*********************** Immutable Implementation of BullionDeliveryLocation  ***********************/
	class BullionDeliveryLocationImpl implements BullionDeliveryLocation {
		private final String value;
		private final String bullionDeliveryLocationScheme;
		
		protected BullionDeliveryLocationImpl(BullionDeliveryLocation.BullionDeliveryLocationBuilder builder) {
			this.value = builder.getValue();
			this.bullionDeliveryLocationScheme = builder.getBullionDeliveryLocationScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("bullionDeliveryLocationScheme")
		public String getBullionDeliveryLocationScheme() {
			return bullionDeliveryLocationScheme;
		}
		
		@Override
		public BullionDeliveryLocation build() {
			return this;
		}
		
		@Override
		public BullionDeliveryLocation.BullionDeliveryLocationBuilder toBuilder() {
			BullionDeliveryLocation.BullionDeliveryLocationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(BullionDeliveryLocation.BullionDeliveryLocationBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getBullionDeliveryLocationScheme()).ifPresent(builder::setBullionDeliveryLocationScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BullionDeliveryLocation _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(bullionDeliveryLocationScheme, _that.getBullionDeliveryLocationScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (bullionDeliveryLocationScheme != null ? bullionDeliveryLocationScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BullionDeliveryLocation {" +
				"value=" + this.value + ", " +
				"bullionDeliveryLocationScheme=" + this.bullionDeliveryLocationScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of BullionDeliveryLocation  ***********************/
	class BullionDeliveryLocationBuilderImpl implements BullionDeliveryLocation.BullionDeliveryLocationBuilder {
	
		protected String value;
		protected String bullionDeliveryLocationScheme;
	
		public BullionDeliveryLocationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("bullionDeliveryLocationScheme")
		public String getBullionDeliveryLocationScheme() {
			return bullionDeliveryLocationScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public BullionDeliveryLocation.BullionDeliveryLocationBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("bullionDeliveryLocationScheme")
		public BullionDeliveryLocation.BullionDeliveryLocationBuilder setBullionDeliveryLocationScheme(String bullionDeliveryLocationScheme) {
			this.bullionDeliveryLocationScheme = bullionDeliveryLocationScheme==null?null:bullionDeliveryLocationScheme;
			return this;
		}
		
		@Override
		public BullionDeliveryLocation build() {
			return new BullionDeliveryLocation.BullionDeliveryLocationImpl(this);
		}
		
		@Override
		public BullionDeliveryLocation.BullionDeliveryLocationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BullionDeliveryLocation.BullionDeliveryLocationBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getBullionDeliveryLocationScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BullionDeliveryLocation.BullionDeliveryLocationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			BullionDeliveryLocation.BullionDeliveryLocationBuilder o = (BullionDeliveryLocation.BullionDeliveryLocationBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getBullionDeliveryLocationScheme(), o.getBullionDeliveryLocationScheme(), this::setBullionDeliveryLocationScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BullionDeliveryLocation _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(bullionDeliveryLocationScheme, _that.getBullionDeliveryLocationScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (bullionDeliveryLocationScheme != null ? bullionDeliveryLocationScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BullionDeliveryLocationBuilder {" +
				"value=" + this.value + ", " +
				"bullionDeliveryLocationScheme=" + this.bullionDeliveryLocationScheme +
			'}';
		}
	}
}
