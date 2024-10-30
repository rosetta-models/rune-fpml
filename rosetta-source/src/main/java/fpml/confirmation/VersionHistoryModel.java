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
import fpml.confirmation.IdentifiedDate;
import fpml.confirmation.VersionHistoryModel;
import fpml.confirmation.VersionHistoryModel.VersionHistoryModelBuilder;
import fpml.confirmation.VersionHistoryModel.VersionHistoryModelBuilderImpl;
import fpml.confirmation.VersionHistoryModel.VersionHistoryModelImpl;
import fpml.confirmation.meta.VersionHistoryModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="VersionHistoryModel", builder=VersionHistoryModel.VersionHistoryModelBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface VersionHistoryModel extends RosettaModelObject {

	VersionHistoryModelMeta metaData = new VersionHistoryModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The version number
	 */
	Integer getVersion();
	/**
	 * Optionally it is possible to specify a version effective date when a versionId is supplied.
	 */
	IdentifiedDate getEffectiveDate();

	/*********************** Build Methods  ***********************/
	VersionHistoryModel build();
	
	VersionHistoryModel.VersionHistoryModelBuilder toBuilder();
	
	static VersionHistoryModel.VersionHistoryModelBuilder builder() {
		return new VersionHistoryModel.VersionHistoryModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends VersionHistoryModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends VersionHistoryModel> getType() {
		return VersionHistoryModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("version"), Integer.class, getVersion(), this);
		processRosetta(path.newSubPath("effectiveDate"), processor, IdentifiedDate.class, getEffectiveDate());
	}
	

	/*********************** Builder Interface  ***********************/
	interface VersionHistoryModelBuilder extends VersionHistoryModel, RosettaModelObjectBuilder {
		IdentifiedDate.IdentifiedDateBuilder getOrCreateEffectiveDate();
		IdentifiedDate.IdentifiedDateBuilder getEffectiveDate();
		VersionHistoryModel.VersionHistoryModelBuilder setVersion(Integer version);
		VersionHistoryModel.VersionHistoryModelBuilder setEffectiveDate(IdentifiedDate effectiveDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("version"), Integer.class, getVersion(), this);
			processRosetta(path.newSubPath("effectiveDate"), processor, IdentifiedDate.IdentifiedDateBuilder.class, getEffectiveDate());
		}
		

		VersionHistoryModel.VersionHistoryModelBuilder prune();
	}

	/*********************** Immutable Implementation of VersionHistoryModel  ***********************/
	class VersionHistoryModelImpl implements VersionHistoryModel {
		private final Integer version;
		private final IdentifiedDate effectiveDate;
		
		protected VersionHistoryModelImpl(VersionHistoryModel.VersionHistoryModelBuilder builder) {
			this.version = builder.getVersion();
			this.effectiveDate = ofNullable(builder.getEffectiveDate()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("version")
		public Integer getVersion() {
			return version;
		}
		
		@Override
		@RosettaAttribute("effectiveDate")
		public IdentifiedDate getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		public VersionHistoryModel build() {
			return this;
		}
		
		@Override
		public VersionHistoryModel.VersionHistoryModelBuilder toBuilder() {
			VersionHistoryModel.VersionHistoryModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(VersionHistoryModel.VersionHistoryModelBuilder builder) {
			ofNullable(getVersion()).ifPresent(builder::setVersion);
			ofNullable(getEffectiveDate()).ifPresent(builder::setEffectiveDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			VersionHistoryModel _that = getType().cast(o);
		
			if (!Objects.equals(version, _that.getVersion())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (version != null ? version.hashCode() : 0);
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "VersionHistoryModel {" +
				"version=" + this.version + ", " +
				"effectiveDate=" + this.effectiveDate +
			'}';
		}
	}

	/*********************** Builder Implementation of VersionHistoryModel  ***********************/
	class VersionHistoryModelBuilderImpl implements VersionHistoryModel.VersionHistoryModelBuilder {
	
		protected Integer version;
		protected IdentifiedDate.IdentifiedDateBuilder effectiveDate;
	
		public VersionHistoryModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("version")
		public Integer getVersion() {
			return version;
		}
		
		@Override
		@RosettaAttribute("effectiveDate")
		public IdentifiedDate.IdentifiedDateBuilder getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		public IdentifiedDate.IdentifiedDateBuilder getOrCreateEffectiveDate() {
			IdentifiedDate.IdentifiedDateBuilder result;
			if (effectiveDate!=null) {
				result = effectiveDate;
			}
			else {
				result = effectiveDate = IdentifiedDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("version")
		public VersionHistoryModel.VersionHistoryModelBuilder setVersion(Integer version) {
			this.version = version==null?null:version;
			return this;
		}
		@Override
		@RosettaAttribute("effectiveDate")
		public VersionHistoryModel.VersionHistoryModelBuilder setEffectiveDate(IdentifiedDate effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate.toBuilder();
			return this;
		}
		
		@Override
		public VersionHistoryModel build() {
			return new VersionHistoryModel.VersionHistoryModelImpl(this);
		}
		
		@Override
		public VersionHistoryModel.VersionHistoryModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public VersionHistoryModel.VersionHistoryModelBuilder prune() {
			if (effectiveDate!=null && !effectiveDate.prune().hasData()) effectiveDate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getVersion()!=null) return true;
			if (getEffectiveDate()!=null && getEffectiveDate().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public VersionHistoryModel.VersionHistoryModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			VersionHistoryModel.VersionHistoryModelBuilder o = (VersionHistoryModel.VersionHistoryModelBuilder) other;
			
			merger.mergeRosetta(getEffectiveDate(), o.getEffectiveDate(), this::setEffectiveDate);
			
			merger.mergeBasic(getVersion(), o.getVersion(), this::setVersion);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			VersionHistoryModel _that = getType().cast(o);
		
			if (!Objects.equals(version, _that.getVersion())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (version != null ? version.hashCode() : 0);
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "VersionHistoryModelBuilder {" +
				"version=" + this.version + ", " +
				"effectiveDate=" + this.effectiveDate +
			'}';
		}
	}
}
