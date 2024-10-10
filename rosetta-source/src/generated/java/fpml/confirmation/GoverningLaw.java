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
import fpml.confirmation.GoverningLaw;
import fpml.confirmation.GoverningLaw.GoverningLawBuilder;
import fpml.confirmation.GoverningLaw.GoverningLawBuilderImpl;
import fpml.confirmation.GoverningLaw.GoverningLawImpl;
import fpml.confirmation.meta.GoverningLawMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Identification of the law governing the transaction.
 * @version ${project.version}
 */
@RosettaDataType(value="GoverningLaw", builder=GoverningLaw.GoverningLawBuilderImpl.class, version="${project.version}")
public interface GoverningLaw extends RosettaModelObject {

	GoverningLawMeta metaData = new GoverningLawMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getGoverningLawScheme();

	/*********************** Build Methods  ***********************/
	GoverningLaw build();
	
	GoverningLaw.GoverningLawBuilder toBuilder();
	
	static GoverningLaw.GoverningLawBuilder builder() {
		return new GoverningLaw.GoverningLawBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends GoverningLaw> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends GoverningLaw> getType() {
		return GoverningLaw.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("governingLawScheme"), String.class, getGoverningLawScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface GoverningLawBuilder extends GoverningLaw, RosettaModelObjectBuilder {
		GoverningLaw.GoverningLawBuilder setValue(String value);
		GoverningLaw.GoverningLawBuilder setGoverningLawScheme(String governingLawScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("governingLawScheme"), String.class, getGoverningLawScheme(), this);
		}
		

		GoverningLaw.GoverningLawBuilder prune();
	}

	/*********************** Immutable Implementation of GoverningLaw  ***********************/
	class GoverningLawImpl implements GoverningLaw {
		private final String value;
		private final String governingLawScheme;
		
		protected GoverningLawImpl(GoverningLaw.GoverningLawBuilder builder) {
			this.value = builder.getValue();
			this.governingLawScheme = builder.getGoverningLawScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("governingLawScheme")
		public String getGoverningLawScheme() {
			return governingLawScheme;
		}
		
		@Override
		public GoverningLaw build() {
			return this;
		}
		
		@Override
		public GoverningLaw.GoverningLawBuilder toBuilder() {
			GoverningLaw.GoverningLawBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(GoverningLaw.GoverningLawBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getGoverningLawScheme()).ifPresent(builder::setGoverningLawScheme);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			GoverningLaw _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(governingLawScheme, _that.getGoverningLawScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (governingLawScheme != null ? governingLawScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GoverningLaw {" +
				"value=" + this.value + ", " +
				"governingLawScheme=" + this.governingLawScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of GoverningLaw  ***********************/
	class GoverningLawBuilderImpl implements GoverningLaw.GoverningLawBuilder {
	
		protected String value;
		protected String governingLawScheme;
	
		public GoverningLawBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("governingLawScheme")
		public String getGoverningLawScheme() {
			return governingLawScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public GoverningLaw.GoverningLawBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("governingLawScheme")
		public GoverningLaw.GoverningLawBuilder setGoverningLawScheme(String governingLawScheme) {
			this.governingLawScheme = governingLawScheme==null?null:governingLawScheme;
			return this;
		}
		
		@Override
		public GoverningLaw build() {
			return new GoverningLaw.GoverningLawImpl(this);
		}
		
		@Override
		public GoverningLaw.GoverningLawBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GoverningLaw.GoverningLawBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getGoverningLawScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GoverningLaw.GoverningLawBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			GoverningLaw.GoverningLawBuilder o = (GoverningLaw.GoverningLawBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getGoverningLawScheme(), o.getGoverningLawScheme(), this::setGoverningLawScheme);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			GoverningLaw _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(governingLawScheme, _that.getGoverningLawScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (governingLawScheme != null ? governingLawScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GoverningLawBuilder {" +
				"value=" + this.value + ", " +
				"governingLawScheme=" + this.governingLawScheme +
			'}';
		}
	}
}
