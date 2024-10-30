package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.TermPoint;
import fpml.confirmation.validation.TermPointTypeFormatValidator;
import fpml.confirmation.validation.TermPointValidator;
import fpml.confirmation.validation.exists.TermPointOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=TermPoint.class)
public class TermPointMeta implements RosettaMetaData<TermPoint> {

	@Override
	public List<Validator<? super TermPoint>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TermPoint, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super TermPoint> validator() {
		return new TermPointValidator();
	}

	@Override
	public Validator<? super TermPoint> typeFormatValidator() {
		return new TermPointTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TermPoint, Set<String>> onlyExistsValidator() {
		return new TermPointOnlyExistsValidator();
	}
}
