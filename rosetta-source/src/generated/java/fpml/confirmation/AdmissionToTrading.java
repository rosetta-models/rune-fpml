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
import fpml.confirmation.AdmissionToTrading;
import fpml.confirmation.AdmissionToTrading.AdmissionToTradingBuilder;
import fpml.confirmation.AdmissionToTrading.AdmissionToTradingBuilderImpl;
import fpml.confirmation.AdmissionToTrading.AdmissionToTradingImpl;
import fpml.confirmation.meta.AdmissionToTradingMeta;
import java.time.ZonedDateTime;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Information about whether and when a product was admitted to trading on a facility.
 * @version ${project.version}
 */
@RosettaDataType(value="AdmissionToTrading", builder=AdmissionToTrading.AdmissionToTradingBuilderImpl.class, version="${project.version}")
public interface AdmissionToTrading extends RosettaModelObject {

	AdmissionToTradingMeta metaData = new AdmissionToTradingMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Whether the issuer of the financial instrument has requested or approved the trading or admission to trading of their financial instruments on a trading venue.
	 */
	Boolean getRequested();
	/**
	 * Date and time of the request for admission to trading on the trading venue.
	 */
	ZonedDateTime getRequestDate();
	/**
	 * Date and time the issuer has approved admission to trading or trading in its financial instruments on a trading venue.
	 */
	ZonedDateTime getApprovalDate();
	/**
	 * Date and time of the admission to trading on the trading venue or the date and time when the instrument was first traded or an order or quote was first received by the trading venue.
	 */
	ZonedDateTime getAdmissionDate();
	/**
	 * Date and time when the financial instrument ceases to be traded or to be admitted to trading on the trading venue.
	 */
	ZonedDateTime getTerminationDate();

	/*********************** Build Methods  ***********************/
	AdmissionToTrading build();
	
	AdmissionToTrading.AdmissionToTradingBuilder toBuilder();
	
	static AdmissionToTrading.AdmissionToTradingBuilder builder() {
		return new AdmissionToTrading.AdmissionToTradingBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AdmissionToTrading> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends AdmissionToTrading> getType() {
		return AdmissionToTrading.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("requested"), Boolean.class, getRequested(), this);
		processor.processBasic(path.newSubPath("requestDate"), ZonedDateTime.class, getRequestDate(), this);
		processor.processBasic(path.newSubPath("approvalDate"), ZonedDateTime.class, getApprovalDate(), this);
		processor.processBasic(path.newSubPath("admissionDate"), ZonedDateTime.class, getAdmissionDate(), this);
		processor.processBasic(path.newSubPath("terminationDate"), ZonedDateTime.class, getTerminationDate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AdmissionToTradingBuilder extends AdmissionToTrading, RosettaModelObjectBuilder {
		AdmissionToTrading.AdmissionToTradingBuilder setRequested(Boolean requested);
		AdmissionToTrading.AdmissionToTradingBuilder setRequestDate(ZonedDateTime requestDate);
		AdmissionToTrading.AdmissionToTradingBuilder setApprovalDate(ZonedDateTime approvalDate);
		AdmissionToTrading.AdmissionToTradingBuilder setAdmissionDate(ZonedDateTime admissionDate);
		AdmissionToTrading.AdmissionToTradingBuilder setTerminationDate(ZonedDateTime terminationDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("requested"), Boolean.class, getRequested(), this);
			processor.processBasic(path.newSubPath("requestDate"), ZonedDateTime.class, getRequestDate(), this);
			processor.processBasic(path.newSubPath("approvalDate"), ZonedDateTime.class, getApprovalDate(), this);
			processor.processBasic(path.newSubPath("admissionDate"), ZonedDateTime.class, getAdmissionDate(), this);
			processor.processBasic(path.newSubPath("terminationDate"), ZonedDateTime.class, getTerminationDate(), this);
		}
		

		AdmissionToTrading.AdmissionToTradingBuilder prune();
	}

	/*********************** Immutable Implementation of AdmissionToTrading  ***********************/
	class AdmissionToTradingImpl implements AdmissionToTrading {
		private final Boolean requested;
		private final ZonedDateTime requestDate;
		private final ZonedDateTime approvalDate;
		private final ZonedDateTime admissionDate;
		private final ZonedDateTime terminationDate;
		
		protected AdmissionToTradingImpl(AdmissionToTrading.AdmissionToTradingBuilder builder) {
			this.requested = builder.getRequested();
			this.requestDate = builder.getRequestDate();
			this.approvalDate = builder.getApprovalDate();
			this.admissionDate = builder.getAdmissionDate();
			this.terminationDate = builder.getTerminationDate();
		}
		
		@Override
		@RosettaAttribute("requested")
		public Boolean getRequested() {
			return requested;
		}
		
		@Override
		@RosettaAttribute("requestDate")
		public ZonedDateTime getRequestDate() {
			return requestDate;
		}
		
		@Override
		@RosettaAttribute("approvalDate")
		public ZonedDateTime getApprovalDate() {
			return approvalDate;
		}
		
		@Override
		@RosettaAttribute("admissionDate")
		public ZonedDateTime getAdmissionDate() {
			return admissionDate;
		}
		
		@Override
		@RosettaAttribute("terminationDate")
		public ZonedDateTime getTerminationDate() {
			return terminationDate;
		}
		
		@Override
		public AdmissionToTrading build() {
			return this;
		}
		
		@Override
		public AdmissionToTrading.AdmissionToTradingBuilder toBuilder() {
			AdmissionToTrading.AdmissionToTradingBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AdmissionToTrading.AdmissionToTradingBuilder builder) {
			ofNullable(getRequested()).ifPresent(builder::setRequested);
			ofNullable(getRequestDate()).ifPresent(builder::setRequestDate);
			ofNullable(getApprovalDate()).ifPresent(builder::setApprovalDate);
			ofNullable(getAdmissionDate()).ifPresent(builder::setAdmissionDate);
			ofNullable(getTerminationDate()).ifPresent(builder::setTerminationDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AdmissionToTrading _that = getType().cast(o);
		
			if (!Objects.equals(requested, _that.getRequested())) return false;
			if (!Objects.equals(requestDate, _that.getRequestDate())) return false;
			if (!Objects.equals(approvalDate, _that.getApprovalDate())) return false;
			if (!Objects.equals(admissionDate, _that.getAdmissionDate())) return false;
			if (!Objects.equals(terminationDate, _that.getTerminationDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (requested != null ? requested.hashCode() : 0);
			_result = 31 * _result + (requestDate != null ? requestDate.hashCode() : 0);
			_result = 31 * _result + (approvalDate != null ? approvalDate.hashCode() : 0);
			_result = 31 * _result + (admissionDate != null ? admissionDate.hashCode() : 0);
			_result = 31 * _result + (terminationDate != null ? terminationDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdmissionToTrading {" +
				"requested=" + this.requested + ", " +
				"requestDate=" + this.requestDate + ", " +
				"approvalDate=" + this.approvalDate + ", " +
				"admissionDate=" + this.admissionDate + ", " +
				"terminationDate=" + this.terminationDate +
			'}';
		}
	}

	/*********************** Builder Implementation of AdmissionToTrading  ***********************/
	class AdmissionToTradingBuilderImpl implements AdmissionToTrading.AdmissionToTradingBuilder {
	
		protected Boolean requested;
		protected ZonedDateTime requestDate;
		protected ZonedDateTime approvalDate;
		protected ZonedDateTime admissionDate;
		protected ZonedDateTime terminationDate;
	
		public AdmissionToTradingBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("requested")
		public Boolean getRequested() {
			return requested;
		}
		
		@Override
		@RosettaAttribute("requestDate")
		public ZonedDateTime getRequestDate() {
			return requestDate;
		}
		
		@Override
		@RosettaAttribute("approvalDate")
		public ZonedDateTime getApprovalDate() {
			return approvalDate;
		}
		
		@Override
		@RosettaAttribute("admissionDate")
		public ZonedDateTime getAdmissionDate() {
			return admissionDate;
		}
		
		@Override
		@RosettaAttribute("terminationDate")
		public ZonedDateTime getTerminationDate() {
			return terminationDate;
		}
		
		@Override
		@RosettaAttribute("requested")
		public AdmissionToTrading.AdmissionToTradingBuilder setRequested(Boolean requested) {
			this.requested = requested==null?null:requested;
			return this;
		}
		@Override
		@RosettaAttribute("requestDate")
		public AdmissionToTrading.AdmissionToTradingBuilder setRequestDate(ZonedDateTime requestDate) {
			this.requestDate = requestDate==null?null:requestDate;
			return this;
		}
		@Override
		@RosettaAttribute("approvalDate")
		public AdmissionToTrading.AdmissionToTradingBuilder setApprovalDate(ZonedDateTime approvalDate) {
			this.approvalDate = approvalDate==null?null:approvalDate;
			return this;
		}
		@Override
		@RosettaAttribute("admissionDate")
		public AdmissionToTrading.AdmissionToTradingBuilder setAdmissionDate(ZonedDateTime admissionDate) {
			this.admissionDate = admissionDate==null?null:admissionDate;
			return this;
		}
		@Override
		@RosettaAttribute("terminationDate")
		public AdmissionToTrading.AdmissionToTradingBuilder setTerminationDate(ZonedDateTime terminationDate) {
			this.terminationDate = terminationDate==null?null:terminationDate;
			return this;
		}
		
		@Override
		public AdmissionToTrading build() {
			return new AdmissionToTrading.AdmissionToTradingImpl(this);
		}
		
		@Override
		public AdmissionToTrading.AdmissionToTradingBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdmissionToTrading.AdmissionToTradingBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getRequested()!=null) return true;
			if (getRequestDate()!=null) return true;
			if (getApprovalDate()!=null) return true;
			if (getAdmissionDate()!=null) return true;
			if (getTerminationDate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdmissionToTrading.AdmissionToTradingBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AdmissionToTrading.AdmissionToTradingBuilder o = (AdmissionToTrading.AdmissionToTradingBuilder) other;
			
			
			merger.mergeBasic(getRequested(), o.getRequested(), this::setRequested);
			merger.mergeBasic(getRequestDate(), o.getRequestDate(), this::setRequestDate);
			merger.mergeBasic(getApprovalDate(), o.getApprovalDate(), this::setApprovalDate);
			merger.mergeBasic(getAdmissionDate(), o.getAdmissionDate(), this::setAdmissionDate);
			merger.mergeBasic(getTerminationDate(), o.getTerminationDate(), this::setTerminationDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AdmissionToTrading _that = getType().cast(o);
		
			if (!Objects.equals(requested, _that.getRequested())) return false;
			if (!Objects.equals(requestDate, _that.getRequestDate())) return false;
			if (!Objects.equals(approvalDate, _that.getApprovalDate())) return false;
			if (!Objects.equals(admissionDate, _that.getAdmissionDate())) return false;
			if (!Objects.equals(terminationDate, _that.getTerminationDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (requested != null ? requested.hashCode() : 0);
			_result = 31 * _result + (requestDate != null ? requestDate.hashCode() : 0);
			_result = 31 * _result + (approvalDate != null ? approvalDate.hashCode() : 0);
			_result = 31 * _result + (admissionDate != null ? admissionDate.hashCode() : 0);
			_result = 31 * _result + (terminationDate != null ? terminationDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdmissionToTradingBuilder {" +
				"requested=" + this.requested + ", " +
				"requestDate=" + this.requestDate + ", " +
				"approvalDate=" + this.approvalDate + ", " +
				"admissionDate=" + this.admissionDate + ", " +
				"terminationDate=" + this.terminationDate +
			'}';
		}
	}
}
