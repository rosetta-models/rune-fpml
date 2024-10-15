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
import fpml.confirmation.FacilityExecutionExceptionDeclaration;
import fpml.confirmation.ReportingRegimeSequence1;
import fpml.confirmation.ReportingRegimeSequence1.ReportingRegimeSequence1Builder;
import fpml.confirmation.ReportingRegimeSequence1.ReportingRegimeSequence1BuilderImpl;
import fpml.confirmation.ReportingRegimeSequence1.ReportingRegimeSequence1Impl;
import fpml.confirmation.meta.ReportingRegimeSequence1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="ReportingRegimeSequence1", builder=ReportingRegimeSequence1.ReportingRegimeSequence1BuilderImpl.class, version="${project.version}")
public interface ReportingRegimeSequence1 extends RosettaModelObject {

	ReportingRegimeSequence1Meta metaData = new ReportingRegimeSequence1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Whether the particular product must be executed on a SEF or DCM. See to Dodd-Frank section 723(a)(8).
	 */
	Boolean getMandatoryFacilityExecution();
	/**
	 * Specifies whether the party invoked exception to not execute the trade on facility such as SEF and DCM even though the particular product is mandated to execute on a SEF.
	 */
	Boolean getMandatoryFacilityExecutionException();
	/**
	 * Provides supporting evidence when a party invoked exception to not execute the trade on facility such as SEF and DCM even though the particular product is mandated to execute on a SEF.
	 */
	FacilityExecutionExceptionDeclaration getMandatoryFacilityExecutionExceptionDeclaration();

	/*********************** Build Methods  ***********************/
	ReportingRegimeSequence1 build();
	
	ReportingRegimeSequence1.ReportingRegimeSequence1Builder toBuilder();
	
	static ReportingRegimeSequence1.ReportingRegimeSequence1Builder builder() {
		return new ReportingRegimeSequence1.ReportingRegimeSequence1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ReportingRegimeSequence1> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ReportingRegimeSequence1> getType() {
		return ReportingRegimeSequence1.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("mandatoryFacilityExecution"), Boolean.class, getMandatoryFacilityExecution(), this);
		processor.processBasic(path.newSubPath("mandatoryFacilityExecutionException"), Boolean.class, getMandatoryFacilityExecutionException(), this);
		processRosetta(path.newSubPath("mandatoryFacilityExecutionExceptionDeclaration"), processor, FacilityExecutionExceptionDeclaration.class, getMandatoryFacilityExecutionExceptionDeclaration());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ReportingRegimeSequence1Builder extends ReportingRegimeSequence1, RosettaModelObjectBuilder {
		FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder getOrCreateMandatoryFacilityExecutionExceptionDeclaration();
		FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder getMandatoryFacilityExecutionExceptionDeclaration();
		ReportingRegimeSequence1.ReportingRegimeSequence1Builder setMandatoryFacilityExecution(Boolean mandatoryFacilityExecution);
		ReportingRegimeSequence1.ReportingRegimeSequence1Builder setMandatoryFacilityExecutionException(Boolean mandatoryFacilityExecutionException);
		ReportingRegimeSequence1.ReportingRegimeSequence1Builder setMandatoryFacilityExecutionExceptionDeclaration(FacilityExecutionExceptionDeclaration mandatoryFacilityExecutionExceptionDeclaration);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("mandatoryFacilityExecution"), Boolean.class, getMandatoryFacilityExecution(), this);
			processor.processBasic(path.newSubPath("mandatoryFacilityExecutionException"), Boolean.class, getMandatoryFacilityExecutionException(), this);
			processRosetta(path.newSubPath("mandatoryFacilityExecutionExceptionDeclaration"), processor, FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder.class, getMandatoryFacilityExecutionExceptionDeclaration());
		}
		

		ReportingRegimeSequence1.ReportingRegimeSequence1Builder prune();
	}

	/*********************** Immutable Implementation of ReportingRegimeSequence1  ***********************/
	class ReportingRegimeSequence1Impl implements ReportingRegimeSequence1 {
		private final Boolean mandatoryFacilityExecution;
		private final Boolean mandatoryFacilityExecutionException;
		private final FacilityExecutionExceptionDeclaration mandatoryFacilityExecutionExceptionDeclaration;
		
		protected ReportingRegimeSequence1Impl(ReportingRegimeSequence1.ReportingRegimeSequence1Builder builder) {
			this.mandatoryFacilityExecution = builder.getMandatoryFacilityExecution();
			this.mandatoryFacilityExecutionException = builder.getMandatoryFacilityExecutionException();
			this.mandatoryFacilityExecutionExceptionDeclaration = ofNullable(builder.getMandatoryFacilityExecutionExceptionDeclaration()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("mandatoryFacilityExecution")
		public Boolean getMandatoryFacilityExecution() {
			return mandatoryFacilityExecution;
		}
		
		@Override
		@RosettaAttribute("mandatoryFacilityExecutionException")
		public Boolean getMandatoryFacilityExecutionException() {
			return mandatoryFacilityExecutionException;
		}
		
		@Override
		@RosettaAttribute("mandatoryFacilityExecutionExceptionDeclaration")
		public FacilityExecutionExceptionDeclaration getMandatoryFacilityExecutionExceptionDeclaration() {
			return mandatoryFacilityExecutionExceptionDeclaration;
		}
		
		@Override
		public ReportingRegimeSequence1 build() {
			return this;
		}
		
		@Override
		public ReportingRegimeSequence1.ReportingRegimeSequence1Builder toBuilder() {
			ReportingRegimeSequence1.ReportingRegimeSequence1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReportingRegimeSequence1.ReportingRegimeSequence1Builder builder) {
			ofNullable(getMandatoryFacilityExecution()).ifPresent(builder::setMandatoryFacilityExecution);
			ofNullable(getMandatoryFacilityExecutionException()).ifPresent(builder::setMandatoryFacilityExecutionException);
			ofNullable(getMandatoryFacilityExecutionExceptionDeclaration()).ifPresent(builder::setMandatoryFacilityExecutionExceptionDeclaration);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReportingRegimeSequence1 _that = getType().cast(o);
		
			if (!Objects.equals(mandatoryFacilityExecution, _that.getMandatoryFacilityExecution())) return false;
			if (!Objects.equals(mandatoryFacilityExecutionException, _that.getMandatoryFacilityExecutionException())) return false;
			if (!Objects.equals(mandatoryFacilityExecutionExceptionDeclaration, _that.getMandatoryFacilityExecutionExceptionDeclaration())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (mandatoryFacilityExecution != null ? mandatoryFacilityExecution.hashCode() : 0);
			_result = 31 * _result + (mandatoryFacilityExecutionException != null ? mandatoryFacilityExecutionException.hashCode() : 0);
			_result = 31 * _result + (mandatoryFacilityExecutionExceptionDeclaration != null ? mandatoryFacilityExecutionExceptionDeclaration.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReportingRegimeSequence1 {" +
				"mandatoryFacilityExecution=" + this.mandatoryFacilityExecution + ", " +
				"mandatoryFacilityExecutionException=" + this.mandatoryFacilityExecutionException + ", " +
				"mandatoryFacilityExecutionExceptionDeclaration=" + this.mandatoryFacilityExecutionExceptionDeclaration +
			'}';
		}
	}

	/*********************** Builder Implementation of ReportingRegimeSequence1  ***********************/
	class ReportingRegimeSequence1BuilderImpl implements ReportingRegimeSequence1.ReportingRegimeSequence1Builder {
	
		protected Boolean mandatoryFacilityExecution;
		protected Boolean mandatoryFacilityExecutionException;
		protected FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder mandatoryFacilityExecutionExceptionDeclaration;
	
		public ReportingRegimeSequence1BuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("mandatoryFacilityExecution")
		public Boolean getMandatoryFacilityExecution() {
			return mandatoryFacilityExecution;
		}
		
		@Override
		@RosettaAttribute("mandatoryFacilityExecutionException")
		public Boolean getMandatoryFacilityExecutionException() {
			return mandatoryFacilityExecutionException;
		}
		
		@Override
		@RosettaAttribute("mandatoryFacilityExecutionExceptionDeclaration")
		public FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder getMandatoryFacilityExecutionExceptionDeclaration() {
			return mandatoryFacilityExecutionExceptionDeclaration;
		}
		
		@Override
		public FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder getOrCreateMandatoryFacilityExecutionExceptionDeclaration() {
			FacilityExecutionExceptionDeclaration.FacilityExecutionExceptionDeclarationBuilder result;
			if (mandatoryFacilityExecutionExceptionDeclaration!=null) {
				result = mandatoryFacilityExecutionExceptionDeclaration;
			}
			else {
				result = mandatoryFacilityExecutionExceptionDeclaration = FacilityExecutionExceptionDeclaration.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("mandatoryFacilityExecution")
		public ReportingRegimeSequence1.ReportingRegimeSequence1Builder setMandatoryFacilityExecution(Boolean mandatoryFacilityExecution) {
			this.mandatoryFacilityExecution = mandatoryFacilityExecution==null?null:mandatoryFacilityExecution;
			return this;
		}
		@Override
		@RosettaAttribute("mandatoryFacilityExecutionException")
		public ReportingRegimeSequence1.ReportingRegimeSequence1Builder setMandatoryFacilityExecutionException(Boolean mandatoryFacilityExecutionException) {
			this.mandatoryFacilityExecutionException = mandatoryFacilityExecutionException==null?null:mandatoryFacilityExecutionException;
			return this;
		}
		@Override
		@RosettaAttribute("mandatoryFacilityExecutionExceptionDeclaration")
		public ReportingRegimeSequence1.ReportingRegimeSequence1Builder setMandatoryFacilityExecutionExceptionDeclaration(FacilityExecutionExceptionDeclaration mandatoryFacilityExecutionExceptionDeclaration) {
			this.mandatoryFacilityExecutionExceptionDeclaration = mandatoryFacilityExecutionExceptionDeclaration==null?null:mandatoryFacilityExecutionExceptionDeclaration.toBuilder();
			return this;
		}
		
		@Override
		public ReportingRegimeSequence1 build() {
			return new ReportingRegimeSequence1.ReportingRegimeSequence1Impl(this);
		}
		
		@Override
		public ReportingRegimeSequence1.ReportingRegimeSequence1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReportingRegimeSequence1.ReportingRegimeSequence1Builder prune() {
			if (mandatoryFacilityExecutionExceptionDeclaration!=null && !mandatoryFacilityExecutionExceptionDeclaration.prune().hasData()) mandatoryFacilityExecutionExceptionDeclaration = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getMandatoryFacilityExecution()!=null) return true;
			if (getMandatoryFacilityExecutionException()!=null) return true;
			if (getMandatoryFacilityExecutionExceptionDeclaration()!=null && getMandatoryFacilityExecutionExceptionDeclaration().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReportingRegimeSequence1.ReportingRegimeSequence1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ReportingRegimeSequence1.ReportingRegimeSequence1Builder o = (ReportingRegimeSequence1.ReportingRegimeSequence1Builder) other;
			
			merger.mergeRosetta(getMandatoryFacilityExecutionExceptionDeclaration(), o.getMandatoryFacilityExecutionExceptionDeclaration(), this::setMandatoryFacilityExecutionExceptionDeclaration);
			
			merger.mergeBasic(getMandatoryFacilityExecution(), o.getMandatoryFacilityExecution(), this::setMandatoryFacilityExecution);
			merger.mergeBasic(getMandatoryFacilityExecutionException(), o.getMandatoryFacilityExecutionException(), this::setMandatoryFacilityExecutionException);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReportingRegimeSequence1 _that = getType().cast(o);
		
			if (!Objects.equals(mandatoryFacilityExecution, _that.getMandatoryFacilityExecution())) return false;
			if (!Objects.equals(mandatoryFacilityExecutionException, _that.getMandatoryFacilityExecutionException())) return false;
			if (!Objects.equals(mandatoryFacilityExecutionExceptionDeclaration, _that.getMandatoryFacilityExecutionExceptionDeclaration())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (mandatoryFacilityExecution != null ? mandatoryFacilityExecution.hashCode() : 0);
			_result = 31 * _result + (mandatoryFacilityExecutionException != null ? mandatoryFacilityExecutionException.hashCode() : 0);
			_result = 31 * _result + (mandatoryFacilityExecutionExceptionDeclaration != null ? mandatoryFacilityExecutionExceptionDeclaration.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReportingRegimeSequence1Builder {" +
				"mandatoryFacilityExecution=" + this.mandatoryFacilityExecution + ", " +
				"mandatoryFacilityExecutionException=" + this.mandatoryFacilityExecutionException + ", " +
				"mandatoryFacilityExecutionExceptionDeclaration=" + this.mandatoryFacilityExecutionExceptionDeclaration +
			'}';
		}
	}
}
