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
import fpml.confirmation.MainPublication;
import fpml.confirmation.MainPublication.MainPublicationBuilder;
import fpml.confirmation.MainPublication.MainPublicationBuilderImpl;
import fpml.confirmation.MainPublication.MainPublicationImpl;
import fpml.confirmation.meta.MainPublicationMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type to define the main publication source.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="MainPublication", builder=MainPublication.MainPublicationBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface MainPublication extends RosettaModelObject {

	MainPublicationMeta metaData = new MainPublicationMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getMainPublicationScheme();

	/*********************** Build Methods  ***********************/
	MainPublication build();
	
	MainPublication.MainPublicationBuilder toBuilder();
	
	static MainPublication.MainPublicationBuilder builder() {
		return new MainPublication.MainPublicationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MainPublication> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends MainPublication> getType() {
		return MainPublication.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("mainPublicationScheme"), String.class, getMainPublicationScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface MainPublicationBuilder extends MainPublication, RosettaModelObjectBuilder {
		MainPublication.MainPublicationBuilder setValue(String value);
		MainPublication.MainPublicationBuilder setMainPublicationScheme(String mainPublicationScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("mainPublicationScheme"), String.class, getMainPublicationScheme(), this);
		}
		

		MainPublication.MainPublicationBuilder prune();
	}

	/*********************** Immutable Implementation of MainPublication  ***********************/
	class MainPublicationImpl implements MainPublication {
		private final String value;
		private final String mainPublicationScheme;
		
		protected MainPublicationImpl(MainPublication.MainPublicationBuilder builder) {
			this.value = builder.getValue();
			this.mainPublicationScheme = builder.getMainPublicationScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("mainPublicationScheme")
		public String getMainPublicationScheme() {
			return mainPublicationScheme;
		}
		
		@Override
		public MainPublication build() {
			return this;
		}
		
		@Override
		public MainPublication.MainPublicationBuilder toBuilder() {
			MainPublication.MainPublicationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MainPublication.MainPublicationBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getMainPublicationScheme()).ifPresent(builder::setMainPublicationScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MainPublication _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(mainPublicationScheme, _that.getMainPublicationScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (mainPublicationScheme != null ? mainPublicationScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MainPublication {" +
				"value=" + this.value + ", " +
				"mainPublicationScheme=" + this.mainPublicationScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of MainPublication  ***********************/
	class MainPublicationBuilderImpl implements MainPublication.MainPublicationBuilder {
	
		protected String value;
		protected String mainPublicationScheme;
	
		public MainPublicationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("mainPublicationScheme")
		public String getMainPublicationScheme() {
			return mainPublicationScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public MainPublication.MainPublicationBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("mainPublicationScheme")
		public MainPublication.MainPublicationBuilder setMainPublicationScheme(String mainPublicationScheme) {
			this.mainPublicationScheme = mainPublicationScheme==null?null:mainPublicationScheme;
			return this;
		}
		
		@Override
		public MainPublication build() {
			return new MainPublication.MainPublicationImpl(this);
		}
		
		@Override
		public MainPublication.MainPublicationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MainPublication.MainPublicationBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getMainPublicationScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MainPublication.MainPublicationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			MainPublication.MainPublicationBuilder o = (MainPublication.MainPublicationBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getMainPublicationScheme(), o.getMainPublicationScheme(), this::setMainPublicationScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MainPublication _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(mainPublicationScheme, _that.getMainPublicationScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (mainPublicationScheme != null ? mainPublicationScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MainPublicationBuilder {" +
				"value=" + this.value + ", " +
				"mainPublicationScheme=" + this.mainPublicationScheme +
			'}';
		}
	}
}
