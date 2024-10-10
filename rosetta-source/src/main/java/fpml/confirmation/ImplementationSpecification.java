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
import com.rosetta.model.lib.records.Date;
import fpml.confirmation.ImplementationSpecification;
import fpml.confirmation.ImplementationSpecification.ImplementationSpecificationBuilder;
import fpml.confirmation.ImplementationSpecification.ImplementationSpecificationBuilderImpl;
import fpml.confirmation.ImplementationSpecification.ImplementationSpecificationImpl;
import fpml.confirmation.ImplementationSpecificationVersion;
import fpml.confirmation.meta.ImplementationSpecificationMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A version of a specification document used by the message generator to format the document.
 * @version ${project.version}
 */
@RosettaDataType(value="ImplementationSpecification", builder=ImplementationSpecification.ImplementationSpecificationBuilderImpl.class, version="${project.version}")
public interface ImplementationSpecification extends RosettaModelObject {

	ImplementationSpecificationMeta metaData = new ImplementationSpecificationMeta();

	/*********************** Getter Methods  ***********************/
	String getName();
	ImplementationSpecificationVersion getVersion();
	Date getDate();

	/*********************** Build Methods  ***********************/
	ImplementationSpecification build();
	
	ImplementationSpecification.ImplementationSpecificationBuilder toBuilder();
	
	static ImplementationSpecification.ImplementationSpecificationBuilder builder() {
		return new ImplementationSpecification.ImplementationSpecificationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ImplementationSpecification> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ImplementationSpecification> getType() {
		return ImplementationSpecification.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
		processRosetta(path.newSubPath("version"), processor, ImplementationSpecificationVersion.class, getVersion());
		processor.processBasic(path.newSubPath("date"), Date.class, getDate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ImplementationSpecificationBuilder extends ImplementationSpecification, RosettaModelObjectBuilder {
		ImplementationSpecificationVersion.ImplementationSpecificationVersionBuilder getOrCreateVersion();
		ImplementationSpecificationVersion.ImplementationSpecificationVersionBuilder getVersion();
		ImplementationSpecification.ImplementationSpecificationBuilder setName(String name);
		ImplementationSpecification.ImplementationSpecificationBuilder setVersion(ImplementationSpecificationVersion version);
		ImplementationSpecification.ImplementationSpecificationBuilder setDate(Date date);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
			processRosetta(path.newSubPath("version"), processor, ImplementationSpecificationVersion.ImplementationSpecificationVersionBuilder.class, getVersion());
			processor.processBasic(path.newSubPath("date"), Date.class, getDate(), this);
		}
		

		ImplementationSpecification.ImplementationSpecificationBuilder prune();
	}

	/*********************** Immutable Implementation of ImplementationSpecification  ***********************/
	class ImplementationSpecificationImpl implements ImplementationSpecification {
		private final String name;
		private final ImplementationSpecificationVersion version;
		private final Date date;
		
		protected ImplementationSpecificationImpl(ImplementationSpecification.ImplementationSpecificationBuilder builder) {
			this.name = builder.getName();
			this.version = ofNullable(builder.getVersion()).map(f->f.build()).orElse(null);
			this.date = builder.getDate();
		}
		
		@Override
		@RosettaAttribute("name")
		public String getName() {
			return name;
		}
		
		@Override
		@RosettaAttribute("version")
		public ImplementationSpecificationVersion getVersion() {
			return version;
		}
		
		@Override
		@RosettaAttribute("date")
		public Date getDate() {
			return date;
		}
		
		@Override
		public ImplementationSpecification build() {
			return this;
		}
		
		@Override
		public ImplementationSpecification.ImplementationSpecificationBuilder toBuilder() {
			ImplementationSpecification.ImplementationSpecificationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ImplementationSpecification.ImplementationSpecificationBuilder builder) {
			ofNullable(getName()).ifPresent(builder::setName);
			ofNullable(getVersion()).ifPresent(builder::setVersion);
			ofNullable(getDate()).ifPresent(builder::setDate);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ImplementationSpecification _that = getType().cast(o);
		
			if (!Objects.equals(name, _that.getName())) return false;
			if (!Objects.equals(version, _that.getVersion())) return false;
			if (!Objects.equals(date, _that.getDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (name != null ? name.hashCode() : 0);
			_result = 31 * _result + (version != null ? version.hashCode() : 0);
			_result = 31 * _result + (date != null ? date.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ImplementationSpecification {" +
				"name=" + this.name + ", " +
				"version=" + this.version + ", " +
				"date=" + this.date +
			'}';
		}
	}

	/*********************** Builder Implementation of ImplementationSpecification  ***********************/
	class ImplementationSpecificationBuilderImpl implements ImplementationSpecification.ImplementationSpecificationBuilder {
	
		protected String name;
		protected ImplementationSpecificationVersion.ImplementationSpecificationVersionBuilder version;
		protected Date date;
	
		public ImplementationSpecificationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("name")
		public String getName() {
			return name;
		}
		
		@Override
		@RosettaAttribute("version")
		public ImplementationSpecificationVersion.ImplementationSpecificationVersionBuilder getVersion() {
			return version;
		}
		
		@Override
		public ImplementationSpecificationVersion.ImplementationSpecificationVersionBuilder getOrCreateVersion() {
			ImplementationSpecificationVersion.ImplementationSpecificationVersionBuilder result;
			if (version!=null) {
				result = version;
			}
			else {
				result = version = ImplementationSpecificationVersion.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("date")
		public Date getDate() {
			return date;
		}
		
		@Override
		@RosettaAttribute("name")
		public ImplementationSpecification.ImplementationSpecificationBuilder setName(String name) {
			this.name = name==null?null:name;
			return this;
		}
		@Override
		@RosettaAttribute("version")
		public ImplementationSpecification.ImplementationSpecificationBuilder setVersion(ImplementationSpecificationVersion version) {
			this.version = version==null?null:version.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("date")
		public ImplementationSpecification.ImplementationSpecificationBuilder setDate(Date date) {
			this.date = date==null?null:date;
			return this;
		}
		
		@Override
		public ImplementationSpecification build() {
			return new ImplementationSpecification.ImplementationSpecificationImpl(this);
		}
		
		@Override
		public ImplementationSpecification.ImplementationSpecificationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ImplementationSpecification.ImplementationSpecificationBuilder prune() {
			if (version!=null && !version.prune().hasData()) version = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getName()!=null) return true;
			if (getVersion()!=null && getVersion().hasData()) return true;
			if (getDate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ImplementationSpecification.ImplementationSpecificationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ImplementationSpecification.ImplementationSpecificationBuilder o = (ImplementationSpecification.ImplementationSpecificationBuilder) other;
			
			merger.mergeRosetta(getVersion(), o.getVersion(), this::setVersion);
			
			merger.mergeBasic(getName(), o.getName(), this::setName);
			merger.mergeBasic(getDate(), o.getDate(), this::setDate);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ImplementationSpecification _that = getType().cast(o);
		
			if (!Objects.equals(name, _that.getName())) return false;
			if (!Objects.equals(version, _that.getVersion())) return false;
			if (!Objects.equals(date, _that.getDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (name != null ? name.hashCode() : 0);
			_result = 31 * _result + (version != null ? version.hashCode() : 0);
			_result = 31 * _result + (date != null ? date.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ImplementationSpecificationBuilder {" +
				"name=" + this.name + ", " +
				"version=" + this.version + ", " +
				"date=" + this.date +
			'}';
		}
	}
}
