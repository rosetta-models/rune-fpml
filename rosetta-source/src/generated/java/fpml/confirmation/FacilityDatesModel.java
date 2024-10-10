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
import fpml.confirmation.FacilityDatesModel;
import fpml.confirmation.FacilityDatesModel.FacilityDatesModelBuilder;
import fpml.confirmation.FacilityDatesModel.FacilityDatesModelBuilderImpl;
import fpml.confirmation.FacilityDatesModel.FacilityDatesModelImpl;
import fpml.confirmation.meta.FacilityDatesModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A model that defines all relevant dates related to a specific facility.
 * @version ${project.version}
 */
@RosettaDataType(value="FacilityDatesModel", builder=FacilityDatesModel.FacilityDatesModelBuilderImpl.class, version="${project.version}")
public interface FacilityDatesModel extends RosettaModelObject {

	FacilityDatesModelMeta metaData = new FacilityDatesModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The start date of the facility.
	 */
	Date getStartDate();
	/**
	 * The latest date that a drawdown can be made effective against the facility.
	 */
	Date getExpiryDate();
	/**
	 * The maturity date of the facility.
	 */
	Date getMaturityDate();

	/*********************** Build Methods  ***********************/
	FacilityDatesModel build();
	
	FacilityDatesModel.FacilityDatesModelBuilder toBuilder();
	
	static FacilityDatesModel.FacilityDatesModelBuilder builder() {
		return new FacilityDatesModel.FacilityDatesModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FacilityDatesModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FacilityDatesModel> getType() {
		return FacilityDatesModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("startDate"), Date.class, getStartDate(), this);
		processor.processBasic(path.newSubPath("expiryDate"), Date.class, getExpiryDate(), this);
		processor.processBasic(path.newSubPath("maturityDate"), Date.class, getMaturityDate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FacilityDatesModelBuilder extends FacilityDatesModel, RosettaModelObjectBuilder {
		FacilityDatesModel.FacilityDatesModelBuilder setStartDate(Date startDate);
		FacilityDatesModel.FacilityDatesModelBuilder setExpiryDate(Date expiryDate);
		FacilityDatesModel.FacilityDatesModelBuilder setMaturityDate(Date maturityDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("startDate"), Date.class, getStartDate(), this);
			processor.processBasic(path.newSubPath("expiryDate"), Date.class, getExpiryDate(), this);
			processor.processBasic(path.newSubPath("maturityDate"), Date.class, getMaturityDate(), this);
		}
		

		FacilityDatesModel.FacilityDatesModelBuilder prune();
	}

	/*********************** Immutable Implementation of FacilityDatesModel  ***********************/
	class FacilityDatesModelImpl implements FacilityDatesModel {
		private final Date startDate;
		private final Date expiryDate;
		private final Date maturityDate;
		
		protected FacilityDatesModelImpl(FacilityDatesModel.FacilityDatesModelBuilder builder) {
			this.startDate = builder.getStartDate();
			this.expiryDate = builder.getExpiryDate();
			this.maturityDate = builder.getMaturityDate();
		}
		
		@Override
		@RosettaAttribute("startDate")
		public Date getStartDate() {
			return startDate;
		}
		
		@Override
		@RosettaAttribute("expiryDate")
		public Date getExpiryDate() {
			return expiryDate;
		}
		
		@Override
		@RosettaAttribute("maturityDate")
		public Date getMaturityDate() {
			return maturityDate;
		}
		
		@Override
		public FacilityDatesModel build() {
			return this;
		}
		
		@Override
		public FacilityDatesModel.FacilityDatesModelBuilder toBuilder() {
			FacilityDatesModel.FacilityDatesModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FacilityDatesModel.FacilityDatesModelBuilder builder) {
			ofNullable(getStartDate()).ifPresent(builder::setStartDate);
			ofNullable(getExpiryDate()).ifPresent(builder::setExpiryDate);
			ofNullable(getMaturityDate()).ifPresent(builder::setMaturityDate);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FacilityDatesModel _that = getType().cast(o);
		
			if (!Objects.equals(startDate, _that.getStartDate())) return false;
			if (!Objects.equals(expiryDate, _that.getExpiryDate())) return false;
			if (!Objects.equals(maturityDate, _that.getMaturityDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (startDate != null ? startDate.hashCode() : 0);
			_result = 31 * _result + (expiryDate != null ? expiryDate.hashCode() : 0);
			_result = 31 * _result + (maturityDate != null ? maturityDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FacilityDatesModel {" +
				"startDate=" + this.startDate + ", " +
				"expiryDate=" + this.expiryDate + ", " +
				"maturityDate=" + this.maturityDate +
			'}';
		}
	}

	/*********************** Builder Implementation of FacilityDatesModel  ***********************/
	class FacilityDatesModelBuilderImpl implements FacilityDatesModel.FacilityDatesModelBuilder {
	
		protected Date startDate;
		protected Date expiryDate;
		protected Date maturityDate;
	
		public FacilityDatesModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("startDate")
		public Date getStartDate() {
			return startDate;
		}
		
		@Override
		@RosettaAttribute("expiryDate")
		public Date getExpiryDate() {
			return expiryDate;
		}
		
		@Override
		@RosettaAttribute("maturityDate")
		public Date getMaturityDate() {
			return maturityDate;
		}
		
		@Override
		@RosettaAttribute("startDate")
		public FacilityDatesModel.FacilityDatesModelBuilder setStartDate(Date startDate) {
			this.startDate = startDate==null?null:startDate;
			return this;
		}
		@Override
		@RosettaAttribute("expiryDate")
		public FacilityDatesModel.FacilityDatesModelBuilder setExpiryDate(Date expiryDate) {
			this.expiryDate = expiryDate==null?null:expiryDate;
			return this;
		}
		@Override
		@RosettaAttribute("maturityDate")
		public FacilityDatesModel.FacilityDatesModelBuilder setMaturityDate(Date maturityDate) {
			this.maturityDate = maturityDate==null?null:maturityDate;
			return this;
		}
		
		@Override
		public FacilityDatesModel build() {
			return new FacilityDatesModel.FacilityDatesModelImpl(this);
		}
		
		@Override
		public FacilityDatesModel.FacilityDatesModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FacilityDatesModel.FacilityDatesModelBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getStartDate()!=null) return true;
			if (getExpiryDate()!=null) return true;
			if (getMaturityDate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FacilityDatesModel.FacilityDatesModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FacilityDatesModel.FacilityDatesModelBuilder o = (FacilityDatesModel.FacilityDatesModelBuilder) other;
			
			
			merger.mergeBasic(getStartDate(), o.getStartDate(), this::setStartDate);
			merger.mergeBasic(getExpiryDate(), o.getExpiryDate(), this::setExpiryDate);
			merger.mergeBasic(getMaturityDate(), o.getMaturityDate(), this::setMaturityDate);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FacilityDatesModel _that = getType().cast(o);
		
			if (!Objects.equals(startDate, _that.getStartDate())) return false;
			if (!Objects.equals(expiryDate, _that.getExpiryDate())) return false;
			if (!Objects.equals(maturityDate, _that.getMaturityDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (startDate != null ? startDate.hashCode() : 0);
			_result = 31 * _result + (expiryDate != null ? expiryDate.hashCode() : 0);
			_result = 31 * _result + (maturityDate != null ? maturityDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FacilityDatesModelBuilder {" +
				"startDate=" + this.startDate + ", " +
				"expiryDate=" + this.expiryDate + ", " +
				"maturityDate=" + this.maturityDate +
			'}';
		}
	}
}
