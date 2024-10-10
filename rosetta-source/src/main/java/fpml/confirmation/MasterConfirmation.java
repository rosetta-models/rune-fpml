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
import fpml.confirmation.MasterConfirmation;
import fpml.confirmation.MasterConfirmation.MasterConfirmationBuilder;
import fpml.confirmation.MasterConfirmation.MasterConfirmationBuilderImpl;
import fpml.confirmation.MasterConfirmation.MasterConfirmationImpl;
import fpml.confirmation.MasterConfirmationAnnexType;
import fpml.confirmation.MasterConfirmationType;
import fpml.confirmation.meta.MasterConfirmationMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * An entity for defining the master confirmation agreement executed between the parties.
 * @version ${project.version}
 */
@RosettaDataType(value="MasterConfirmation", builder=MasterConfirmation.MasterConfirmationBuilderImpl.class, version="${project.version}")
public interface MasterConfirmation extends RosettaModelObject {

	MasterConfirmationMeta metaData = new MasterConfirmationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The type of master confirmation executed between the parties.
	 */
	MasterConfirmationType getMasterConfirmationType();
	/**
	 * The date of the confirmation executed between the parties and intended to govern all relevant transactions between those parties.
	 */
	Date getMasterConfirmationDate();
	/**
	 * The date that an annex to the master confirmation was executed between the parties.
	 */
	Date getMasterConfirmationAnnexDate();
	/**
	 * The type of master confirmation annex executed between the parties.
	 */
	MasterConfirmationAnnexType getMasterConfirmationAnnexType();

	/*********************** Build Methods  ***********************/
	MasterConfirmation build();
	
	MasterConfirmation.MasterConfirmationBuilder toBuilder();
	
	static MasterConfirmation.MasterConfirmationBuilder builder() {
		return new MasterConfirmation.MasterConfirmationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MasterConfirmation> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends MasterConfirmation> getType() {
		return MasterConfirmation.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("masterConfirmationType"), processor, MasterConfirmationType.class, getMasterConfirmationType());
		processor.processBasic(path.newSubPath("masterConfirmationDate"), Date.class, getMasterConfirmationDate(), this);
		processor.processBasic(path.newSubPath("masterConfirmationAnnexDate"), Date.class, getMasterConfirmationAnnexDate(), this);
		processRosetta(path.newSubPath("masterConfirmationAnnexType"), processor, MasterConfirmationAnnexType.class, getMasterConfirmationAnnexType());
	}
	

	/*********************** Builder Interface  ***********************/
	interface MasterConfirmationBuilder extends MasterConfirmation, RosettaModelObjectBuilder {
		MasterConfirmationType.MasterConfirmationTypeBuilder getOrCreateMasterConfirmationType();
		MasterConfirmationType.MasterConfirmationTypeBuilder getMasterConfirmationType();
		MasterConfirmationAnnexType.MasterConfirmationAnnexTypeBuilder getOrCreateMasterConfirmationAnnexType();
		MasterConfirmationAnnexType.MasterConfirmationAnnexTypeBuilder getMasterConfirmationAnnexType();
		MasterConfirmation.MasterConfirmationBuilder setMasterConfirmationType(MasterConfirmationType masterConfirmationType);
		MasterConfirmation.MasterConfirmationBuilder setMasterConfirmationDate(Date masterConfirmationDate);
		MasterConfirmation.MasterConfirmationBuilder setMasterConfirmationAnnexDate(Date masterConfirmationAnnexDate);
		MasterConfirmation.MasterConfirmationBuilder setMasterConfirmationAnnexType(MasterConfirmationAnnexType masterConfirmationAnnexType);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("masterConfirmationType"), processor, MasterConfirmationType.MasterConfirmationTypeBuilder.class, getMasterConfirmationType());
			processor.processBasic(path.newSubPath("masterConfirmationDate"), Date.class, getMasterConfirmationDate(), this);
			processor.processBasic(path.newSubPath("masterConfirmationAnnexDate"), Date.class, getMasterConfirmationAnnexDate(), this);
			processRosetta(path.newSubPath("masterConfirmationAnnexType"), processor, MasterConfirmationAnnexType.MasterConfirmationAnnexTypeBuilder.class, getMasterConfirmationAnnexType());
		}
		

		MasterConfirmation.MasterConfirmationBuilder prune();
	}

	/*********************** Immutable Implementation of MasterConfirmation  ***********************/
	class MasterConfirmationImpl implements MasterConfirmation {
		private final MasterConfirmationType masterConfirmationType;
		private final Date masterConfirmationDate;
		private final Date masterConfirmationAnnexDate;
		private final MasterConfirmationAnnexType masterConfirmationAnnexType;
		
		protected MasterConfirmationImpl(MasterConfirmation.MasterConfirmationBuilder builder) {
			this.masterConfirmationType = ofNullable(builder.getMasterConfirmationType()).map(f->f.build()).orElse(null);
			this.masterConfirmationDate = builder.getMasterConfirmationDate();
			this.masterConfirmationAnnexDate = builder.getMasterConfirmationAnnexDate();
			this.masterConfirmationAnnexType = ofNullable(builder.getMasterConfirmationAnnexType()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("masterConfirmationType")
		public MasterConfirmationType getMasterConfirmationType() {
			return masterConfirmationType;
		}
		
		@Override
		@RosettaAttribute("masterConfirmationDate")
		public Date getMasterConfirmationDate() {
			return masterConfirmationDate;
		}
		
		@Override
		@RosettaAttribute("masterConfirmationAnnexDate")
		public Date getMasterConfirmationAnnexDate() {
			return masterConfirmationAnnexDate;
		}
		
		@Override
		@RosettaAttribute("masterConfirmationAnnexType")
		public MasterConfirmationAnnexType getMasterConfirmationAnnexType() {
			return masterConfirmationAnnexType;
		}
		
		@Override
		public MasterConfirmation build() {
			return this;
		}
		
		@Override
		public MasterConfirmation.MasterConfirmationBuilder toBuilder() {
			MasterConfirmation.MasterConfirmationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MasterConfirmation.MasterConfirmationBuilder builder) {
			ofNullable(getMasterConfirmationType()).ifPresent(builder::setMasterConfirmationType);
			ofNullable(getMasterConfirmationDate()).ifPresent(builder::setMasterConfirmationDate);
			ofNullable(getMasterConfirmationAnnexDate()).ifPresent(builder::setMasterConfirmationAnnexDate);
			ofNullable(getMasterConfirmationAnnexType()).ifPresent(builder::setMasterConfirmationAnnexType);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MasterConfirmation _that = getType().cast(o);
		
			if (!Objects.equals(masterConfirmationType, _that.getMasterConfirmationType())) return false;
			if (!Objects.equals(masterConfirmationDate, _that.getMasterConfirmationDate())) return false;
			if (!Objects.equals(masterConfirmationAnnexDate, _that.getMasterConfirmationAnnexDate())) return false;
			if (!Objects.equals(masterConfirmationAnnexType, _that.getMasterConfirmationAnnexType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (masterConfirmationType != null ? masterConfirmationType.hashCode() : 0);
			_result = 31 * _result + (masterConfirmationDate != null ? masterConfirmationDate.hashCode() : 0);
			_result = 31 * _result + (masterConfirmationAnnexDate != null ? masterConfirmationAnnexDate.hashCode() : 0);
			_result = 31 * _result + (masterConfirmationAnnexType != null ? masterConfirmationAnnexType.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MasterConfirmation {" +
				"masterConfirmationType=" + this.masterConfirmationType + ", " +
				"masterConfirmationDate=" + this.masterConfirmationDate + ", " +
				"masterConfirmationAnnexDate=" + this.masterConfirmationAnnexDate + ", " +
				"masterConfirmationAnnexType=" + this.masterConfirmationAnnexType +
			'}';
		}
	}

	/*********************** Builder Implementation of MasterConfirmation  ***********************/
	class MasterConfirmationBuilderImpl implements MasterConfirmation.MasterConfirmationBuilder {
	
		protected MasterConfirmationType.MasterConfirmationTypeBuilder masterConfirmationType;
		protected Date masterConfirmationDate;
		protected Date masterConfirmationAnnexDate;
		protected MasterConfirmationAnnexType.MasterConfirmationAnnexTypeBuilder masterConfirmationAnnexType;
	
		public MasterConfirmationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("masterConfirmationType")
		public MasterConfirmationType.MasterConfirmationTypeBuilder getMasterConfirmationType() {
			return masterConfirmationType;
		}
		
		@Override
		public MasterConfirmationType.MasterConfirmationTypeBuilder getOrCreateMasterConfirmationType() {
			MasterConfirmationType.MasterConfirmationTypeBuilder result;
			if (masterConfirmationType!=null) {
				result = masterConfirmationType;
			}
			else {
				result = masterConfirmationType = MasterConfirmationType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("masterConfirmationDate")
		public Date getMasterConfirmationDate() {
			return masterConfirmationDate;
		}
		
		@Override
		@RosettaAttribute("masterConfirmationAnnexDate")
		public Date getMasterConfirmationAnnexDate() {
			return masterConfirmationAnnexDate;
		}
		
		@Override
		@RosettaAttribute("masterConfirmationAnnexType")
		public MasterConfirmationAnnexType.MasterConfirmationAnnexTypeBuilder getMasterConfirmationAnnexType() {
			return masterConfirmationAnnexType;
		}
		
		@Override
		public MasterConfirmationAnnexType.MasterConfirmationAnnexTypeBuilder getOrCreateMasterConfirmationAnnexType() {
			MasterConfirmationAnnexType.MasterConfirmationAnnexTypeBuilder result;
			if (masterConfirmationAnnexType!=null) {
				result = masterConfirmationAnnexType;
			}
			else {
				result = masterConfirmationAnnexType = MasterConfirmationAnnexType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("masterConfirmationType")
		public MasterConfirmation.MasterConfirmationBuilder setMasterConfirmationType(MasterConfirmationType masterConfirmationType) {
			this.masterConfirmationType = masterConfirmationType==null?null:masterConfirmationType.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("masterConfirmationDate")
		public MasterConfirmation.MasterConfirmationBuilder setMasterConfirmationDate(Date masterConfirmationDate) {
			this.masterConfirmationDate = masterConfirmationDate==null?null:masterConfirmationDate;
			return this;
		}
		@Override
		@RosettaAttribute("masterConfirmationAnnexDate")
		public MasterConfirmation.MasterConfirmationBuilder setMasterConfirmationAnnexDate(Date masterConfirmationAnnexDate) {
			this.masterConfirmationAnnexDate = masterConfirmationAnnexDate==null?null:masterConfirmationAnnexDate;
			return this;
		}
		@Override
		@RosettaAttribute("masterConfirmationAnnexType")
		public MasterConfirmation.MasterConfirmationBuilder setMasterConfirmationAnnexType(MasterConfirmationAnnexType masterConfirmationAnnexType) {
			this.masterConfirmationAnnexType = masterConfirmationAnnexType==null?null:masterConfirmationAnnexType.toBuilder();
			return this;
		}
		
		@Override
		public MasterConfirmation build() {
			return new MasterConfirmation.MasterConfirmationImpl(this);
		}
		
		@Override
		public MasterConfirmation.MasterConfirmationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MasterConfirmation.MasterConfirmationBuilder prune() {
			if (masterConfirmationType!=null && !masterConfirmationType.prune().hasData()) masterConfirmationType = null;
			if (masterConfirmationAnnexType!=null && !masterConfirmationAnnexType.prune().hasData()) masterConfirmationAnnexType = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getMasterConfirmationType()!=null && getMasterConfirmationType().hasData()) return true;
			if (getMasterConfirmationDate()!=null) return true;
			if (getMasterConfirmationAnnexDate()!=null) return true;
			if (getMasterConfirmationAnnexType()!=null && getMasterConfirmationAnnexType().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MasterConfirmation.MasterConfirmationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			MasterConfirmation.MasterConfirmationBuilder o = (MasterConfirmation.MasterConfirmationBuilder) other;
			
			merger.mergeRosetta(getMasterConfirmationType(), o.getMasterConfirmationType(), this::setMasterConfirmationType);
			merger.mergeRosetta(getMasterConfirmationAnnexType(), o.getMasterConfirmationAnnexType(), this::setMasterConfirmationAnnexType);
			
			merger.mergeBasic(getMasterConfirmationDate(), o.getMasterConfirmationDate(), this::setMasterConfirmationDate);
			merger.mergeBasic(getMasterConfirmationAnnexDate(), o.getMasterConfirmationAnnexDate(), this::setMasterConfirmationAnnexDate);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MasterConfirmation _that = getType().cast(o);
		
			if (!Objects.equals(masterConfirmationType, _that.getMasterConfirmationType())) return false;
			if (!Objects.equals(masterConfirmationDate, _that.getMasterConfirmationDate())) return false;
			if (!Objects.equals(masterConfirmationAnnexDate, _that.getMasterConfirmationAnnexDate())) return false;
			if (!Objects.equals(masterConfirmationAnnexType, _that.getMasterConfirmationAnnexType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (masterConfirmationType != null ? masterConfirmationType.hashCode() : 0);
			_result = 31 * _result + (masterConfirmationDate != null ? masterConfirmationDate.hashCode() : 0);
			_result = 31 * _result + (masterConfirmationAnnexDate != null ? masterConfirmationAnnexDate.hashCode() : 0);
			_result = 31 * _result + (masterConfirmationAnnexType != null ? masterConfirmationAnnexType.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MasterConfirmationBuilder {" +
				"masterConfirmationType=" + this.masterConfirmationType + ", " +
				"masterConfirmationDate=" + this.masterConfirmationDate + ", " +
				"masterConfirmationAnnexDate=" + this.masterConfirmationAnnexDate + ", " +
				"masterConfirmationAnnexType=" + this.masterConfirmationAnnexType +
			'}';
		}
	}
}
