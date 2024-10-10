package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.SettlementPostponement;
import fpml.confirmation.validation.SettlementPostponementTypeFormatValidator;
import fpml.confirmation.validation.SettlementPostponementValidator;
import fpml.confirmation.validation.exists.SettlementPostponementOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=SettlementPostponement.class)
public class SettlementPostponementMeta implements RosettaMetaData<SettlementPostponement> {

	@Override
	public List<Validator<? super SettlementPostponement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SettlementPostponement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super SettlementPostponement> validator() {
		return new SettlementPostponementValidator();
	}

	@Override
	public Validator<? super SettlementPostponement> typeFormatValidator() {
		return new SettlementPostponementTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SettlementPostponement, Set<String>> onlyExistsValidator() {
		return new SettlementPostponementOnlyExistsValidator();
	}
}
