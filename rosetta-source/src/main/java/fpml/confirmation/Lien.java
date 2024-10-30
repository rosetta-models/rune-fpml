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
import fpml.confirmation.Lien;
import fpml.confirmation.Lien.LienBuilder;
import fpml.confirmation.Lien.LienBuilderImpl;
import fpml.confirmation.Lien.LienImpl;
import fpml.confirmation.meta.LienMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type describing the liens associated with a loan facility.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="Lien", builder=Lien.LienBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface Lien extends RosettaModelObject {

	LienMeta metaData = new LienMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getLienScheme();

	/*********************** Build Methods  ***********************/
	Lien build();
	
	Lien.LienBuilder toBuilder();
	
	static Lien.LienBuilder builder() {
		return new Lien.LienBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Lien> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends Lien> getType() {
		return Lien.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("lienScheme"), String.class, getLienScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface LienBuilder extends Lien, RosettaModelObjectBuilder {
		Lien.LienBuilder setValue(String value);
		Lien.LienBuilder setLienScheme(String lienScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("lienScheme"), String.class, getLienScheme(), this);
		}
		

		Lien.LienBuilder prune();
	}

	/*********************** Immutable Implementation of Lien  ***********************/
	class LienImpl implements Lien {
		private final String value;
		private final String lienScheme;
		
		protected LienImpl(Lien.LienBuilder builder) {
			this.value = builder.getValue();
			this.lienScheme = builder.getLienScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("lienScheme")
		public String getLienScheme() {
			return lienScheme;
		}
		
		@Override
		public Lien build() {
			return this;
		}
		
		@Override
		public Lien.LienBuilder toBuilder() {
			Lien.LienBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Lien.LienBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getLienScheme()).ifPresent(builder::setLienScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Lien _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(lienScheme, _that.getLienScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (lienScheme != null ? lienScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Lien {" +
				"value=" + this.value + ", " +
				"lienScheme=" + this.lienScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of Lien  ***********************/
	class LienBuilderImpl implements Lien.LienBuilder {
	
		protected String value;
		protected String lienScheme;
	
		public LienBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("lienScheme")
		public String getLienScheme() {
			return lienScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public Lien.LienBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("lienScheme")
		public Lien.LienBuilder setLienScheme(String lienScheme) {
			this.lienScheme = lienScheme==null?null:lienScheme;
			return this;
		}
		
		@Override
		public Lien build() {
			return new Lien.LienImpl(this);
		}
		
		@Override
		public Lien.LienBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Lien.LienBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getLienScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Lien.LienBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Lien.LienBuilder o = (Lien.LienBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getLienScheme(), o.getLienScheme(), this::setLienScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Lien _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(lienScheme, _that.getLienScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (lienScheme != null ? lienScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LienBuilder {" +
				"value=" + this.value + ", " +
				"lienScheme=" + this.lienScheme +
			'}';
		}
	}
}
