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
import fpml.confirmation.FutureId;
import fpml.confirmation.FutureId.FutureIdBuilder;
import fpml.confirmation.FutureId.FutureIdBuilderImpl;
import fpml.confirmation.FutureId.FutureIdImpl;
import fpml.confirmation.meta.FutureIdMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type defining a short form unique identifier for a future contract.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="FutureId", builder=FutureId.FutureIdBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface FutureId extends RosettaModelObject {

	FutureIdMeta metaData = new FutureIdMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getFutureIdScheme();

	/*********************** Build Methods  ***********************/
	FutureId build();
	
	FutureId.FutureIdBuilder toBuilder();
	
	static FutureId.FutureIdBuilder builder() {
		return new FutureId.FutureIdBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FutureId> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FutureId> getType() {
		return FutureId.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("futureIdScheme"), String.class, getFutureIdScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FutureIdBuilder extends FutureId, RosettaModelObjectBuilder {
		FutureId.FutureIdBuilder setValue(String value);
		FutureId.FutureIdBuilder setFutureIdScheme(String futureIdScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("futureIdScheme"), String.class, getFutureIdScheme(), this);
		}
		

		FutureId.FutureIdBuilder prune();
	}

	/*********************** Immutable Implementation of FutureId  ***********************/
	class FutureIdImpl implements FutureId {
		private final String value;
		private final String futureIdScheme;
		
		protected FutureIdImpl(FutureId.FutureIdBuilder builder) {
			this.value = builder.getValue();
			this.futureIdScheme = builder.getFutureIdScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("futureIdScheme")
		public String getFutureIdScheme() {
			return futureIdScheme;
		}
		
		@Override
		public FutureId build() {
			return this;
		}
		
		@Override
		public FutureId.FutureIdBuilder toBuilder() {
			FutureId.FutureIdBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FutureId.FutureIdBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getFutureIdScheme()).ifPresent(builder::setFutureIdScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FutureId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(futureIdScheme, _that.getFutureIdScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (futureIdScheme != null ? futureIdScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FutureId {" +
				"value=" + this.value + ", " +
				"futureIdScheme=" + this.futureIdScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of FutureId  ***********************/
	class FutureIdBuilderImpl implements FutureId.FutureIdBuilder {
	
		protected String value;
		protected String futureIdScheme;
	
		public FutureIdBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("futureIdScheme")
		public String getFutureIdScheme() {
			return futureIdScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public FutureId.FutureIdBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("futureIdScheme")
		public FutureId.FutureIdBuilder setFutureIdScheme(String futureIdScheme) {
			this.futureIdScheme = futureIdScheme==null?null:futureIdScheme;
			return this;
		}
		
		@Override
		public FutureId build() {
			return new FutureId.FutureIdImpl(this);
		}
		
		@Override
		public FutureId.FutureIdBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FutureId.FutureIdBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getFutureIdScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FutureId.FutureIdBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FutureId.FutureIdBuilder o = (FutureId.FutureIdBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getFutureIdScheme(), o.getFutureIdScheme(), this::setFutureIdScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FutureId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(futureIdScheme, _that.getFutureIdScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (futureIdScheme != null ? futureIdScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FutureIdBuilder {" +
				"value=" + this.value + ", " +
				"futureIdScheme=" + this.futureIdScheme +
			'}';
		}
	}
}
