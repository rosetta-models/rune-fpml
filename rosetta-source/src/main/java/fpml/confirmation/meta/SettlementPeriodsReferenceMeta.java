package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.SettlementPeriodsReference;
import fpml.confirmation.validation.SettlementPeriodsReferenceTypeFormatValidator;
import fpml.confirmation.validation.SettlementPeriodsReferenceValidator;
import fpml.confirmation.validation.exists.SettlementPeriodsReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=SettlementPeriodsReference.class)
public class SettlementPeriodsReferenceMeta implements RosettaMetaData<SettlementPeriodsReference> {

	@Override
	public List<Validator<? super SettlementPeriodsReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SettlementPeriodsReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super SettlementPeriodsReference> validator() {
		return new SettlementPeriodsReferenceValidator();
	}

	@Override
	public Validator<? super SettlementPeriodsReference> typeFormatValidator() {
		return new SettlementPeriodsReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SettlementPeriodsReference, Set<String>> onlyExistsValidator() {
		return new SettlementPeriodsReferenceOnlyExistsValidator();
	}
}
