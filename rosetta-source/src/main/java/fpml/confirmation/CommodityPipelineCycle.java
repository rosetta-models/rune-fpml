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
import fpml.confirmation.CommodityPipelineCycle;
import fpml.confirmation.CommodityPipelineCycle.CommodityPipelineCycleBuilder;
import fpml.confirmation.CommodityPipelineCycle.CommodityPipelineCycleBuilderImpl;
import fpml.confirmation.CommodityPipelineCycle.CommodityPipelineCycleImpl;
import fpml.confirmation.meta.CommodityPipelineCycleMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The pipeline cycle during which the physical commodity will be delivered.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="CommodityPipelineCycle", builder=CommodityPipelineCycle.CommodityPipelineCycleBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface CommodityPipelineCycle extends RosettaModelObject {

	CommodityPipelineCycleMeta metaData = new CommodityPipelineCycleMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getPipelineCycleScheme();

	/*********************** Build Methods  ***********************/
	CommodityPipelineCycle build();
	
	CommodityPipelineCycle.CommodityPipelineCycleBuilder toBuilder();
	
	static CommodityPipelineCycle.CommodityPipelineCycleBuilder builder() {
		return new CommodityPipelineCycle.CommodityPipelineCycleBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityPipelineCycle> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityPipelineCycle> getType() {
		return CommodityPipelineCycle.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("pipelineCycleScheme"), String.class, getPipelineCycleScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityPipelineCycleBuilder extends CommodityPipelineCycle, RosettaModelObjectBuilder {
		CommodityPipelineCycle.CommodityPipelineCycleBuilder setValue(String value);
		CommodityPipelineCycle.CommodityPipelineCycleBuilder setPipelineCycleScheme(String pipelineCycleScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("pipelineCycleScheme"), String.class, getPipelineCycleScheme(), this);
		}
		

		CommodityPipelineCycle.CommodityPipelineCycleBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityPipelineCycle  ***********************/
	class CommodityPipelineCycleImpl implements CommodityPipelineCycle {
		private final String value;
		private final String pipelineCycleScheme;
		
		protected CommodityPipelineCycleImpl(CommodityPipelineCycle.CommodityPipelineCycleBuilder builder) {
			this.value = builder.getValue();
			this.pipelineCycleScheme = builder.getPipelineCycleScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("pipelineCycleScheme")
		public String getPipelineCycleScheme() {
			return pipelineCycleScheme;
		}
		
		@Override
		public CommodityPipelineCycle build() {
			return this;
		}
		
		@Override
		public CommodityPipelineCycle.CommodityPipelineCycleBuilder toBuilder() {
			CommodityPipelineCycle.CommodityPipelineCycleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityPipelineCycle.CommodityPipelineCycleBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getPipelineCycleScheme()).ifPresent(builder::setPipelineCycleScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityPipelineCycle _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(pipelineCycleScheme, _that.getPipelineCycleScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (pipelineCycleScheme != null ? pipelineCycleScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityPipelineCycle {" +
				"value=" + this.value + ", " +
				"pipelineCycleScheme=" + this.pipelineCycleScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityPipelineCycle  ***********************/
	class CommodityPipelineCycleBuilderImpl implements CommodityPipelineCycle.CommodityPipelineCycleBuilder {
	
		protected String value;
		protected String pipelineCycleScheme;
	
		public CommodityPipelineCycleBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("pipelineCycleScheme")
		public String getPipelineCycleScheme() {
			return pipelineCycleScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public CommodityPipelineCycle.CommodityPipelineCycleBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("pipelineCycleScheme")
		public CommodityPipelineCycle.CommodityPipelineCycleBuilder setPipelineCycleScheme(String pipelineCycleScheme) {
			this.pipelineCycleScheme = pipelineCycleScheme==null?null:pipelineCycleScheme;
			return this;
		}
		
		@Override
		public CommodityPipelineCycle build() {
			return new CommodityPipelineCycle.CommodityPipelineCycleImpl(this);
		}
		
		@Override
		public CommodityPipelineCycle.CommodityPipelineCycleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityPipelineCycle.CommodityPipelineCycleBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getPipelineCycleScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityPipelineCycle.CommodityPipelineCycleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityPipelineCycle.CommodityPipelineCycleBuilder o = (CommodityPipelineCycle.CommodityPipelineCycleBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getPipelineCycleScheme(), o.getPipelineCycleScheme(), this::setPipelineCycleScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityPipelineCycle _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(pipelineCycleScheme, _that.getPipelineCycleScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (pipelineCycleScheme != null ? pipelineCycleScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityPipelineCycleBuilder {" +
				"value=" + this.value + ", " +
				"pipelineCycleScheme=" + this.pipelineCycleScheme +
			'}';
		}
	}
}
