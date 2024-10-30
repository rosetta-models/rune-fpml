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
import fpml.confirmation.MgmtData;
import fpml.confirmation.MgmtData.MgmtDataBuilder;
import fpml.confirmation.MgmtData.MgmtDataBuilderImpl;
import fpml.confirmation.MgmtData.MgmtDataImpl;
import fpml.confirmation.meta.MgmtDataMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="MgmtData", builder=MgmtData.MgmtDataBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface MgmtData extends RosettaModelObject {

	MgmtDataMeta metaData = new MgmtDataMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();

	/*********************** Build Methods  ***********************/
	MgmtData build();
	
	MgmtData.MgmtDataBuilder toBuilder();
	
	static MgmtData.MgmtDataBuilder builder() {
		return new MgmtData.MgmtDataBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MgmtData> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends MgmtData> getType() {
		return MgmtData.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface MgmtDataBuilder extends MgmtData, RosettaModelObjectBuilder {
		MgmtData.MgmtDataBuilder setValue(String value);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		}
		

		MgmtData.MgmtDataBuilder prune();
	}

	/*********************** Immutable Implementation of MgmtData  ***********************/
	class MgmtDataImpl implements MgmtData {
		private final String value;
		
		protected MgmtDataImpl(MgmtData.MgmtDataBuilder builder) {
			this.value = builder.getValue();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		public MgmtData build() {
			return this;
		}
		
		@Override
		public MgmtData.MgmtDataBuilder toBuilder() {
			MgmtData.MgmtDataBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MgmtData.MgmtDataBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MgmtData _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MgmtData {" +
				"value=" + this.value +
			'}';
		}
	}

	/*********************** Builder Implementation of MgmtData  ***********************/
	class MgmtDataBuilderImpl implements MgmtData.MgmtDataBuilder {
	
		protected String value;
	
		public MgmtDataBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("value")
		public MgmtData.MgmtDataBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		
		@Override
		public MgmtData build() {
			return new MgmtData.MgmtDataImpl(this);
		}
		
		@Override
		public MgmtData.MgmtDataBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MgmtData.MgmtDataBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MgmtData.MgmtDataBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			MgmtData.MgmtDataBuilder o = (MgmtData.MgmtDataBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MgmtData _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MgmtDataBuilder {" +
				"value=" + this.value +
			'}';
		}
	}
}
