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
import fpml.confirmation.MortgageSector;
import fpml.confirmation.MortgageSector.MortgageSectorBuilder;
import fpml.confirmation.MortgageSector.MortgageSectorBuilderImpl;
import fpml.confirmation.MortgageSector.MortgageSectorImpl;
import fpml.confirmation.meta.MortgageSectorMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type describing the typology of mortgage obligations.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="MortgageSector", builder=MortgageSector.MortgageSectorBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface MortgageSector extends RosettaModelObject {

	MortgageSectorMeta metaData = new MortgageSectorMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getMortgageSectorScheme();

	/*********************** Build Methods  ***********************/
	MortgageSector build();
	
	MortgageSector.MortgageSectorBuilder toBuilder();
	
	static MortgageSector.MortgageSectorBuilder builder() {
		return new MortgageSector.MortgageSectorBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MortgageSector> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends MortgageSector> getType() {
		return MortgageSector.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("mortgageSectorScheme"), String.class, getMortgageSectorScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface MortgageSectorBuilder extends MortgageSector, RosettaModelObjectBuilder {
		MortgageSector.MortgageSectorBuilder setValue(String value);
		MortgageSector.MortgageSectorBuilder setMortgageSectorScheme(String mortgageSectorScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("mortgageSectorScheme"), String.class, getMortgageSectorScheme(), this);
		}
		

		MortgageSector.MortgageSectorBuilder prune();
	}

	/*********************** Immutable Implementation of MortgageSector  ***********************/
	class MortgageSectorImpl implements MortgageSector {
		private final String value;
		private final String mortgageSectorScheme;
		
		protected MortgageSectorImpl(MortgageSector.MortgageSectorBuilder builder) {
			this.value = builder.getValue();
			this.mortgageSectorScheme = builder.getMortgageSectorScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("mortgageSectorScheme")
		public String getMortgageSectorScheme() {
			return mortgageSectorScheme;
		}
		
		@Override
		public MortgageSector build() {
			return this;
		}
		
		@Override
		public MortgageSector.MortgageSectorBuilder toBuilder() {
			MortgageSector.MortgageSectorBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MortgageSector.MortgageSectorBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getMortgageSectorScheme()).ifPresent(builder::setMortgageSectorScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MortgageSector _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(mortgageSectorScheme, _that.getMortgageSectorScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (mortgageSectorScheme != null ? mortgageSectorScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MortgageSector {" +
				"value=" + this.value + ", " +
				"mortgageSectorScheme=" + this.mortgageSectorScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of MortgageSector  ***********************/
	class MortgageSectorBuilderImpl implements MortgageSector.MortgageSectorBuilder {
	
		protected String value;
		protected String mortgageSectorScheme;
	
		public MortgageSectorBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("mortgageSectorScheme")
		public String getMortgageSectorScheme() {
			return mortgageSectorScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public MortgageSector.MortgageSectorBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("mortgageSectorScheme")
		public MortgageSector.MortgageSectorBuilder setMortgageSectorScheme(String mortgageSectorScheme) {
			this.mortgageSectorScheme = mortgageSectorScheme==null?null:mortgageSectorScheme;
			return this;
		}
		
		@Override
		public MortgageSector build() {
			return new MortgageSector.MortgageSectorImpl(this);
		}
		
		@Override
		public MortgageSector.MortgageSectorBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MortgageSector.MortgageSectorBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getMortgageSectorScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MortgageSector.MortgageSectorBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			MortgageSector.MortgageSectorBuilder o = (MortgageSector.MortgageSectorBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getMortgageSectorScheme(), o.getMortgageSectorScheme(), this::setMortgageSectorScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MortgageSector _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(mortgageSectorScheme, _that.getMortgageSectorScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (mortgageSectorScheme != null ? mortgageSectorScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MortgageSectorBuilder {" +
				"value=" + this.value + ", " +
				"mortgageSectorScheme=" + this.mortgageSectorScheme +
			'}';
		}
	}
}
